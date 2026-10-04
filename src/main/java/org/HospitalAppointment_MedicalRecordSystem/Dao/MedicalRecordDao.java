package org.HospitalAppointment_MedicalRecordSystem.Dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.HospitalAppointment_MedicalRecordSystem.Dto.MedicalRecordRequestDto;
import org.HospitalAppointment_MedicalRecordSystem.Entity.Appointment;
import org.HospitalAppointment_MedicalRecordSystem.Entity.AppointmentStatus;
import org.HospitalAppointment_MedicalRecordSystem.Entity.Doctor;
import org.HospitalAppointment_MedicalRecordSystem.Entity.MedicalRecord;
import org.HospitalAppointment_MedicalRecordSystem.Entity.Patient;
import org.HospitalAppointment_MedicalRecordSystem.Exception.DoctorIdNotFoundException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.IdNotFoundException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.IllegalArgumentValidException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.MedicalRecordAlreadyFoundException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.NoRecordAvailableException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.PatientIdNotFoundException;
import org.HospitalAppointment_MedicalRecordSystem.Repositary.AppointmentRepositary;
import org.HospitalAppointment_MedicalRecordSystem.Repositary.DoctorRepositary;
import org.HospitalAppointment_MedicalRecordSystem.Repositary.MedicalRecordRepositary;
import org.HospitalAppointment_MedicalRecordSystem.Repositary.PatientRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MedicalRecordDao {

	@Autowired
	private MedicalRecordRepositary medicalRecordRepositary;
	@Autowired
	private DoctorRepositary doctorRepositary;
	@Autowired
	private PatientRepositary patientRepositary;
	@Autowired
	private AppointmentRepositary appointmentRepositary;
	
	//Create Record or Insert Record----------
	public MedicalRecord saveMedicalRecord(MedicalRecordRequestDto dto) {
		if(dto.getDoctorId() == null) {
			throw new IllegalArgumentValidException("Doctor Id Must Be Pass For Create The Medical Record In DB!");
		}
		if(dto.getPatientId() == null) {
			throw new IllegalArgumentValidException("Patient Id Must Be Pass For Create The Medical Record In DB!");
		}
		
		//Check The GIven Medical Record Already Exist For Appointment in DB or Not
		boolean existRecord = medicalRecordRepositary.existsByPatientPatientIdAndDoctorDoctorIdAndVisitDate(dto.getPatientId(),dto.getDoctorId(),dto.getVisitDate());
		if(existRecord) {
			throw new MedicalRecordAlreadyFoundException("Medical Record Already Exists For The PatientId: "+dto.getPatientId()+" In DB!");
		}
	
		Optional<Doctor> doctor = doctorRepositary.findById(dto.getDoctorId());
		if(doctor.isEmpty()) {
			throw new PatientIdNotFoundException("Patient Record With DeptName: "+dto.getPatientId()+" Had Not Been Found In DB!");
		}
		Optional<Patient> patient = patientRepositary.findById(dto.getPatientId());
		if(patient.isEmpty()) {
			throw new DoctorIdNotFoundException("Doctor Record With DeptName: "+dto.getDoctorId()+" Had Not Been Found In DB!");
		}
		
		//Extract The Date From The Table and then match the visitDate and Table Date if both are match then next step proceed 
		LocalDate visitDate = dto.getVisitDate();
		LocalDateTime start = visitDate.atStartOfDay(); //Like 00:00:00
		LocalDateTime end = visitDate.atTime(23, 59, 59);
		
		Optional<Appointment> appointment = appointmentRepositary.findCompleteAppointmentForVisit(dto.getPatientId(), dto.getDoctorId(), start, end);
		//if The both Date visitDate and Extract Date From the table Had Been Matched
		if(appointment.isPresent()) {
			//If the AppointmentStatus is COMPLETED then Create Medical Record
			if(appointment.get().getAppointmentStatus() == AppointmentStatus.COMPLETED) {
				MedicalRecord record = new MedicalRecord();
				record.setDiagonistics(dto.getDiagonistics());
				record.setTreatment(dto.getTreatment());
				record.setVisitDate(dto.getVisitDate());
				record.setDoctor(doctor.get());
				record.setPatient(patient.get());
				
				return medicalRecordRepositary.save(record);
			}
			//If the AppointmentStatus is CANCELED or BOOKED then we can't had To Create Medical Record
			else {
				throw new IllegalArgumentValidException("Medical Record can only be created when AppointmentStatus is COMPLETED In DB!");
			}
		}
		//If the Both Dates are not Matched
		else {
			throw new IllegalArgumentValidException("Specific Date Had Been Not Matched!");
		}
		
		
	}

	//Fetch All The Medical Record
	public List<MedicalRecord> fetchAllMedicalRecord() {
		List<MedicalRecord> li = medicalRecordRepositary.findAll();
		if(!li.isEmpty()) {
			return li;
		}
		else {
			throw new NoRecordAvailableException("Medical Record Had Been Not Found In DB!");
		}
	}

	//Fetch Medical Record By Using visitDate
	public MedicalRecord fetchMedicalRecordByUsingRecordId(Integer recordId) {
		Optional<MedicalRecord> record = medicalRecordRepositary.findById(recordId);
		if(record.isPresent()) {
			return record.get();
		}
		else {
			throw new IdNotFoundException("Medical Record With RecordID: "+recordId+" Had Not Been Found In DB!");
		}
	}

	//Fetch Medical Record By Using visitDate
	public List<MedicalRecord> fetchMedicalRecordByUsingVisitDate(LocalDate visitDate) {
		List<MedicalRecord> li = medicalRecordRepositary.findByvisitDate(visitDate);
		if(!li.isEmpty()) {
			return li;
		}
		else {
			throw new NoRecordAvailableException("Medical Record Had Been Not Found For VisitDate: "+visitDate+" In DB!");
		}
	}

	//Fetch Medical Record By Using PatientId
	public List<MedicalRecord> fetchMedicalRecordByUsingPatientId(Integer patientId) {
		List<MedicalRecord> li = medicalRecordRepositary.findByPatientPatientId(patientId);
		if(!li.isEmpty()) {
			return li;
		}
		else {
			throw new NoRecordAvailableException("Medical Record Had Been Not Found For PatientId: "+patientId+" In DB!");
		}
	}

	//Fetch Medical Record By Using DoctorId
	public List<MedicalRecord> fetchMedicalRecordByUsingDoctorId(Integer doctorId) {
		List<MedicalRecord> li = medicalRecordRepositary.findByDoctorDoctorId(doctorId);
		if(!li.isEmpty()) {
			return li;
		}
		else {
			throw new NoRecordAvailableException("Medical Record Had Been Not Found For DoctorId: "+doctorId+" In DB!");
		
		}
	}

	//Fetch Medical Record By Using AppointmentId
	public List<MedicalRecord> fetchMedicalRecordByUsingAppointmentId(Integer appointmentId) {
		List<MedicalRecord> li = medicalRecordRepositary.findMedicalRecordPAppointmentId(appointmentId);
		if(!li.isEmpty()) {
			return li;
		}
		else {
			throw new NoRecordAvailableException("Medical Record Had Been Not Found For AppointmentId: "+appointmentId+" In DB!");
		}
	}

}

















