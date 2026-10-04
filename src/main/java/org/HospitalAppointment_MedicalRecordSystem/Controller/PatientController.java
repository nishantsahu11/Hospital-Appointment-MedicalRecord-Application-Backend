package org.HospitalAppointment_MedicalRecordSystem.Controller;

import java.util.List;

import org.HospitalAppointment_MedicalRecordSystem.Dto.ResponseStructure;
import org.HospitalAppointment_MedicalRecordSystem.Entity.Patient;
import org.HospitalAppointment_MedicalRecordSystem.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	//Register Patient or Insert Patient
	@PostMapping()
	public ResponseEntity<ResponseStructure<Patient>> savePatient(@RequestBody Patient patient){
		return patientService.savePatient(patient);
	}
	
	//Fetch All Patient Record
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Patient>>> fetchAllPatient(){
		return patientService.fetchAllPatient();
	}
	
	//Fetch Patient Record By Using PatientId
	@GetMapping("/patientId/{patientId}")
	public ResponseEntity<ResponseStructure<Patient>> fetchPatientByUsingPatientId(@PathVariable Integer patientId){
		return patientService.fetchPatientByUsingPatientId(patientId);
	}
	
	//Fetch Patient Record By Using PhoneNumber
	@GetMapping("/phoneNum/{phoneNumber}")
	public ResponseEntity<ResponseStructure<Patient>> fetchPatientByUsingPhoneNumber(@PathVariable Long phoneNumber){
		return patientService.fetchPatientByUsingPhoneNumber(phoneNumber);
	}
	
	//Fetch Patient Record where Age is GreaterThan
	@GetMapping("/age/{patientAge}")
	public ResponseEntity<ResponseStructure<List<Patient>>> fetchPatientWhereAgeIsGreaterThan(@PathVariable Integer patientAge){
		return patientService.fetchPatientWhereAgeIsGreaterThan(patientAge);
	}
	
	//Fetch Patient Record By Using AppointmentId
	@GetMapping("/appointmentId/{appointmentId}")
	public ResponseEntity<ResponseStructure<Patient>> fetchPatientRecordByUsingAppointmentId(@PathVariable Integer appointmentId){
		return patientService.fetchPatientRecordByUsingAppointmentId(appointmentId);
	}
		
	//Fetch Patient Record By Using Medical RecordId
	@GetMapping("/medicalrecordId/{recordId}")
	public ResponseEntity<ResponseStructure<Patient>> fetchPatientRecordByUsingMedicalRecordId(@PathVariable Integer recordId){
		return patientService.fetchPatientRecordByUsingMedicalRecordId(recordId);
	}
	
	//Delete Patient Record By Using PatientId
	@DeleteMapping("/{patientId}")
	public ResponseEntity<ResponseStructure<String>> deletePatientByUsingPatientId(@PathVariable Integer patientId){
		return patientService.deletePatientByUsingPatientId(patientId);
	}
	
	//Update Patient Record By Using PatientId
	@PutMapping()
	public ResponseEntity<ResponseStructure<Patient>> updatePatientByUsingPatientId(@RequestBody Patient patient){
		return patientService.updatePatientByUsingPatientId(patient);
	}
	
	
}






















