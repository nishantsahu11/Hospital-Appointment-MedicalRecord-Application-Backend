package org.HospitalAppointment_MedicalRecordSystem.Controller;

import java.time.LocalDate;
import java.util.List;

import org.HospitalAppointment_MedicalRecordSystem.Dto.AppointmentRequestDto;
import org.HospitalAppointment_MedicalRecordSystem.Dto.AppointmentUpdateDto;
import org.HospitalAppointment_MedicalRecordSystem.Dto.ResponseStructure;
import org.HospitalAppointment_MedicalRecordSystem.Entity.Appointment;
import org.HospitalAppointment_MedicalRecordSystem.Entity.AppointmentStatus;
import org.HospitalAppointment_MedicalRecordSystem.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired 
	private AppointmentService appointmentService;
	
	//Book Appointment or Create Appointment
	@PostMapping()
	public ResponseEntity<ResponseStructure<Appointment>> saveAppointment(@RequestBody AppointmentRequestDto dto){
		return appointmentService.saveAppointment(dto);
	}
	
	//Fetch All Appointment
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAllAppointment(){
		return appointmentService.fetchAllAppointment();
	}
	
	//Fetch Appointment Record By Using AppointmentId
	@GetMapping("/appointmentId/{appointmentId}")
	public ResponseEntity<ResponseStructure<Appointment>> fetchAppointmentByUsingAppointmentId(@PathVariable Integer appointmentId){
		return appointmentService.fetchAppointmentByUsingAppointmentId(appointmentId);
	}
	
	//Fetch Appointment Record By Using Date
	@GetMapping("/date/{date}")
	public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByUsingDate(@PathVariable LocalDate date){
		return appointmentService.fetchAppointmentByUsingDate(date);
	}
	
	//Fetch Appointment Record By Using Status
	@GetMapping("/status/{appointmentStatus}")
	public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByUsingAppointmentStatus(@PathVariable AppointmentStatus appointmentStatus){
		return appointmentService.fetchAppointmentByUsingAppointmentStatus(appointmentStatus);
	}
	
	//Fetch Appointment Record By Using DoctorId
	@GetMapping("/doctorId/{doctorId}")
	public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByUsingDoctorId(@PathVariable Integer doctorId){
		return appointmentService.fetchAppointmentByUsingDoctorId(doctorId);
	}
		
	//Fetch Appointment Record By Using PatientId
	@GetMapping("/patientId/{patientId}")
	public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByUsingPatientId(@PathVariable Integer patientId){
		return appointmentService.fetchAppointmentByUsingPatientId(patientId);
	}
	
	//Update AppointmentStatus (BOOKED->CANCELED and BOOK->COMPLETED, we can't update the status of CANCELED and COMPLETED)
	@PutMapping("/updateStatus")
	public ResponseEntity<ResponseStructure<Appointment>> updateAppointmentStatusByUsingAppointmentId(@RequestBody AppointmentUpdateDto dto){
		return appointmentService.updateAppointmentStatusByUsingAppointmentId(dto);
	}
	
	////Update or Cancel AppointmentStatus From BOOKED to CANCELED
	@PutMapping("/cancelStatus")
	public ResponseEntity<ResponseStructure<Appointment>> updateAppointmentFromBookedToCanceled(@RequestBody AppointmentUpdateDto dto){
		return appointmentService.updateAppointmentFromBookedToCanceled(dto);
	}
	
	
	
	
}













