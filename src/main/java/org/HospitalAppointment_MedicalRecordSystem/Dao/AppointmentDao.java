package org.HospitalAppointment_MedicalRecordSystem.Dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.HospitalAppointment_MedicalRecordSystem.Dto.AppointmentRequestDto;
import org.HospitalAppointment_MedicalRecordSystem.Dto.AppointmentUpdateDto;
import org.HospitalAppointment_MedicalRecordSystem.Entity.Appointment;
import org.HospitalAppointment_MedicalRecordSystem.Entity.AppointmentStatus;
import org.HospitalAppointment_MedicalRecordSystem.Entity.Doctor;
import org.HospitalAppointment_MedicalRecordSystem.Entity.Patient;
import org.HospitalAppointment_MedicalRecordSystem.Exception.DoctorIdNotFoundException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.IdNotFoundException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.IllegalArgumentValidException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.NoRecordAvailableException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.PatientIdNotFoundException;
import org.HospitalAppointment_MedicalRecordSystem.Repositary.AppointmentRepositary;
import org.HospitalAppointment_MedicalRecordSystem.Repositary.DoctorRepositary;
import org.HospitalAppointment_MedicalRecordSystem.Repositary.PatientRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentDao {

	@Autowired
	private AppointmentRepositary appointmentRepositary;
	@Autowired
	private DoctorRepositary doctorRepositary;
	@Autowired
	private PatientRepositary patientRepositary;
	
	//Book Appointment or Create Appointment
	public Appointment saveAppointment(AppointmentRequestDto dto) {
		if(dto.getDoctorId() == null) {
			throw new IllegalArgumentValidException("Doctor Id Must Be Pass For Insert The Record In DB!");
		}
		if(dto.getPatientId() == null) {
			throw new IllegalArgumentValidException("Patient Id Must Be Pass For Insert The Record In DB!");
		}
		Optional<Doctor> doc = doctorRepositary.findById(dto.getDoctorId());
		Optional<Patient> pat = patientRepositary.findById(dto.getPatientId());
		//-----Patient - One Appointment per Day
		LocalDate date = dto.getAppointmentDateTime().toLocalDate(); 
		LocalDateTime startofDay = date.atStartOfDay(); //00:00:00
		LocalDateTime endOfDay = date.atTime(23, 59, 59); //23:59:59
		List<Appointment> existingPatientAppointment = appointmentRepositary.findAppointmentsForPatientOnDate(dto.getPatientId(), startofDay, endOfDay);
		//------Doctor - No same-time appointment
		List<Appointment> existingDoctorAppointment = appointmentRepositary.findDoctorAppointmentAtSameTime(dto.getDoctorId(), dto.getAppointmentDateTime());
		
		//If On the Given Date Patient can't have Appointment
		if(existingPatientAppointment.isEmpty()) {
			//If At the Given Time Doctor can't have Appointment
			if(existingDoctorAppointment.isEmpty()) {
				if(doc.isPresent()) {
					if(pat.isPresent()) {
						Appointment appointment = new Appointment();
						appointment.setAppointmentDateTime(dto.getAppointmentDateTime());
						appointment.setAppointmentStatus(dto.getAppointmentStatus());
						appointment.setDoctors(doc.get());
						appointment.setPatient(pat.get());
						
						return appointmentRepositary.save(appointment);
					}
					//Patient Id Not Found In DB
					else {
						throw new PatientIdNotFoundException("Patient Record With DeptName: "+dto.getPatientId()+" Had Not Been Found In DB!");
					}
				}
				//Doctor Id Not Found In DB
				else {
					throw new DoctorIdNotFoundException("Doctor Record With DeptName: "+dto.getDoctorId()+" Had Not Been Found In DB!");
				}
			}
			//If At the Given Time Doctor already have 1 Appointment
			else {
				throw new IllegalArgumentValidException("Doctor Can't Have More Than 1 Appointment At The Same Time!");
			}
		}
		//If On the Given Date Patient already have 1 Appointment
		else {
			throw new IllegalArgumentValidException("Patient Can't Have More Than 1 Appointment On The Same Day!");
		}
	}

	//Fetch All Appointment Records
	public List<Appointment> fetchAllAppointment() {
		List<Appointment> li = appointmentRepositary.findAll();
		if(!li.isEmpty()) {
			return li;
		}
		else {
			throw new NoRecordAvailableException("Appointment Record Had Been Not Found In DB!");
		}
	}
	
	//Fetch Appointment Records By Using AppointmentId
	public Appointment fetchAppointmentByUsingAppointmentId(Integer appointmentId) {
		Optional<Appointment> opt = appointmentRepositary.findById(appointmentId);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new IdNotFoundException("Appointment Record With ID: "+appointmentId+" Had Not Been Found In DB!");
		}
	}

	//Fetch Appointment Records By Using Date
	public List<Appointment> fetchAppointmentByUsingDate(LocalDate date) {
		LocalDateTime start = date.atStartOfDay(); //00:00:00
		LocalDateTime end = date.atTime(23, 59, 59); //23:59:59
		List<Appointment> li = appointmentRepositary.findAppointmentForDate(start, end);
		if(!li.isEmpty()) {
			return li;
		}
		else {
			throw new NoRecordAvailableException("Appointment Record Had Been Not Found In DB!");
		}
	}

	//Fetch Appointment Record By Using AppointmentStatus
	public List<Appointment> fetchAppointmentByUsingAppointmentStatus(AppointmentStatus appointmentStatus) {
		List<Appointment> li = appointmentRepositary.findByappointmentStatus(appointmentStatus);
		if(!li.isEmpty()) {
			return li;
		}
		else {
			throw new NoRecordAvailableException("Appointment Record Had Been Not Found For AppointmentStatus: "+appointmentStatus+" In DB!");
		}
	}

	//Fetch Appointment Record By Using DoctorId
	public List<Appointment> fetchAppointmentByUsingDoctorId(Integer doctorId) {
		List<Appointment> li = appointmentRepositary.findByDoctorDoctorId(doctorId);
		if(!li.isEmpty()) {
			return li;
		}
		else {
			throw new NoRecordAvailableException("Appointment Record Had Been Not Found For DoctorId: "+doctorId+" In DB!");
		}
	}

	//Fetch Appointment Record By Using PatientId
	public List<Appointment> fetchAppointmentByUsingPatientId(Integer patientId) {
		List<Appointment> li = appointmentRepositary.findByPatientPatientId(patientId);
		if(!li.isEmpty()) {
			return li;
		}
		else {
			throw new NoRecordAvailableException("Appointment Record Had Been Not Found For PatientId: "+patientId+" In DB!");
		}
	}
	
	
	//Update AppointmentStatus
	public Appointment updateAppointmentStatusByUsingAppointmentId(AppointmentUpdateDto dto) {
		if(dto.getAppointmentId() == null) {
			throw new IllegalArgumentValidException("Appointment Id Must Be Pass For Update The AppointmentStatus In DB!");
		}
		Optional<Appointment> appointment = appointmentRepositary.findById(dto.getAppointmentId());
		if(appointment.isPresent()) {
			AppointmentStatus currStatus = appointment.get().getAppointmentStatus();
			//If currStatus is BOOKED then we Updated As => BOOKED->CANCELED and BOOKED->COMPLETED
			if(currStatus == AppointmentStatus.BOOKED) {
				int updateId = appointmentRepositary.updateAppointmentStatus(dto.getAppointmentId(), dto.getAppointmentStatus());
				return appointmentRepositary.findById(dto.getAppointmentId()).get();
			}
			//If currStatus is CANCELED then we can't Updated As => CANCELED->BOOKED and CANCELED->COMPLETED (bcz Data becomes In-consistence)
			else if(currStatus == AppointmentStatus.CANCELED){
				throw new IllegalArgumentValidException("Canceled Appointment Can't Be Updated In DB!");
			}
			//If currStatus is COMPLETED then we can't Updated As => COMPLETED->CANCELED and COMPLETED->BOOKED (bcz Data becomes In-consistence)
			else {
				throw new IllegalArgumentValidException("Completed Appointment Can't Be Updated In DB!");
			}
		}
		
		else {
			throw new IdNotFoundException("Appointment Record With ID: "+dto.getAppointmentId()+" Had Not Been Found In DB!");
		}
	}

	//Update AppointmentStatus From BOOKED to CANCELED
	public Appointment updateAppointmentFromBookedToCanceled(AppointmentUpdateDto dto) {
		if(dto.getAppointmentId() == null) {
			throw new IllegalArgumentValidException("Appointment Id Must Be Pass For Update The AppointmentStatus In DB!");
		}
		
		Optional<Appointment> appointment = appointmentRepositary.findById(dto.getAppointmentId());
		
		if(appointment.isPresent()) {
			AppointmentStatus currStatus = appointment.get().getAppointmentStatus();
			//If currStatus is BOOKED then we Updated As => BOOKED->CANCELED
			if(currStatus == AppointmentStatus.BOOKED) {
				int updateId = appointmentRepositary.updateAppointmentStatus(dto.getAppointmentId(), dto.getAppointmentStatus());
				return appointment.get();
				
			}
			//If currStatus is CANCELED then we can't Updated As => CANCELED->CANCELED
			else if(currStatus == AppointmentStatus.CANCELED) {
				throw new IllegalArgumentValidException("Canceled Appointment Can't Be Updated As Canceled In DB!");
			}
			//If currStatus is COMPLETED then we can't Updated As => COMPLETED->CANCELED
			else {
				throw new IllegalArgumentValidException("Completed Appointment Can't Be Updated As Canceled In DB!");
			}
		}
		else {
			throw new IdNotFoundException("Appointment Record With ID: "+dto.getAppointmentId()+" Had Not Been Found In DB!");
		}
		
	}

	

	
	

}



















