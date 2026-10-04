package org.HospitalAppointment_MedicalRecordSystem.Service;

import java.time.LocalDate;
import java.util.List;

import org.HospitalAppointment_MedicalRecordSystem.Dao.AppointmentDao;
import org.HospitalAppointment_MedicalRecordSystem.Dto.AppointmentRequestDto;
import org.HospitalAppointment_MedicalRecordSystem.Dto.AppointmentUpdateDto;
import org.HospitalAppointment_MedicalRecordSystem.Dto.ResponseStructure;
import org.HospitalAppointment_MedicalRecordSystem.Entity.Appointment;
import org.HospitalAppointment_MedicalRecordSystem.Entity.AppointmentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentDao appointmentDao;
	
	//Book Appointment or Create Appointment
	public ResponseEntity<ResponseStructure<Appointment>> saveAppointment(AppointmentRequestDto dto) {
		ResponseStructure<Appointment> resp = new ResponseStructure<Appointment>();
		resp.setStatusCode(HttpStatus.CREATED.value());
		resp.setMessage("Appointment Had Been Created In DB!");
		resp.setData(appointmentDao.saveAppointment(dto));
		
		return new ResponseEntity<ResponseStructure<Appointment>>(resp,HttpStatus.CREATED);
	}

	//Fetch All Appointment Record
	public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAllAppointment() {
		ResponseStructure<List<Appointment>> resp = new ResponseStructure<List<Appointment>>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Display All Apointments From DB!");
		resp.setData(appointmentDao.fetchAllAppointment());
		
		return new ResponseEntity<ResponseStructure<List<Appointment>>>(resp,HttpStatus.FOUND);
	}
	
	//Fetch Appointment Record By Using AppointmentId
	public ResponseEntity<ResponseStructure<Appointment>> fetchAppointmentByUsingAppointmentId(Integer appointmentId) {
		ResponseStructure<Appointment> resp = new ResponseStructure<Appointment>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Appointment Record With AppointmentId: "+appointmentId+" Had Been Found From DB!");
		resp.setData(appointmentDao.fetchAppointmentByUsingAppointmentId(appointmentId));
		return new ResponseEntity<ResponseStructure<Appointment>>(resp,HttpStatus.CREATED);
	}

	//Fetch Appointment Record By Using Date
	public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByUsingDate(LocalDate date) {
		ResponseStructure<List<Appointment>> resp = new ResponseStructure<List<Appointment>>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Display All Apointments From DB!");
		resp.setData(appointmentDao.fetchAppointmentByUsingDate(date));
		
		return new ResponseEntity<ResponseStructure<List<Appointment>>>(resp,HttpStatus.FOUND);
	
	}

	//Fetch Appointment Record By Using AppointmentStatus
	public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByUsingAppointmentStatus(
			AppointmentStatus appointmentStatus) {
		ResponseStructure<List<Appointment>> resp = new ResponseStructure<List<Appointment>>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Display All Apointments From DB!");
		resp.setData(appointmentDao.fetchAppointmentByUsingAppointmentStatus(appointmentStatus));
		
		return new ResponseEntity<ResponseStructure<List<Appointment>>>(resp,HttpStatus.FOUND);
	}
	
	//Fetch Appointment Record By Using DoctorId
	public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByUsingDoctorId(Integer doctorId) {
		ResponseStructure<List<Appointment>> resp = new ResponseStructure<List<Appointment>>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Appointment Status Had Been Found For DoctorId: "+doctorId+" From DB");
		resp.setData(appointmentDao.fetchAppointmentByUsingDoctorId(doctorId));
			
		return new ResponseEntity<ResponseStructure<List<Appointment>>>(resp,HttpStatus.FOUND);
	}

	//Fetch Appointment Record By Using PatientId
	public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByUsingPatientId(Integer patientId) {
		ResponseStructure<List<Appointment>> resp = new ResponseStructure<List<Appointment>>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Appointment Status Had Been Found For PatientId: "+patientId+" From DB");
		resp.setData(appointmentDao.fetchAppointmentByUsingPatientId(patientId));
			
		return new ResponseEntity<ResponseStructure<List<Appointment>>>(resp,HttpStatus.FOUND);
	}


	//Update AppointmentStatus
	public ResponseEntity<ResponseStructure<Appointment>> updateAppointmentStatusByUsingAppointmentId(
			AppointmentUpdateDto dto) {
		ResponseStructure<Appointment> resp = new ResponseStructure<Appointment>();
		resp.setStatusCode(HttpStatus.OK.value());
		resp.setMessage("Appointment Status Had Been Updated From DB!");
		resp.setData(appointmentDao.updateAppointmentStatusByUsingAppointmentId(dto));
		return new ResponseEntity<ResponseStructure<Appointment>>(resp,HttpStatus.OK);
	}

	//Update AppointmentStatus From BOOKED to CANCELED
	public ResponseEntity<ResponseStructure<Appointment>> updateAppointmentFromBookedToCanceled(
			AppointmentUpdateDto dto) {
		ResponseStructure<Appointment> resp = new ResponseStructure<Appointment>();
		resp.setStatusCode(HttpStatus.OK.value());
		resp.setMessage("Appointment Status Had Been Updated From BOOKED To CANCELED");
		resp.setData(appointmentDao.updateAppointmentFromBookedToCanceled(dto));
		
		return new ResponseEntity<ResponseStructure<Appointment>>(resp,HttpStatus.OK);
	}

	

}


















