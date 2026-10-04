package org.HospitalAppointment_MedicalRecordSystem.Controller;

import java.time.LocalDate;
import java.util.List;

import org.HospitalAppointment_MedicalRecordSystem.Dto.MedicalRecordRequestDto;
import org.HospitalAppointment_MedicalRecordSystem.Dto.ResponseStructure;
import org.HospitalAppointment_MedicalRecordSystem.Entity.MedicalRecord;
import org.HospitalAppointment_MedicalRecordSystem.Service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicalRecord")
public class MedicalRecordController {

	@Autowired 
	private MedicalRecordService medicalRecordService;
	
	//Create Record or Insert Record
	@PostMapping()
	public ResponseEntity<ResponseStructure<MedicalRecord>> saveMedicalRecord(@RequestBody MedicalRecordRequestDto dto){
		return medicalRecordService.saveMedicalRecord(dto);
	}
	
	//Fetch All Medical Record
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchAllMedicalRecord(){
		return medicalRecordService.fetchAllMedicalRecord();
	}
	
	//Fetch Medical Record By Using RecordId
	@GetMapping("/recordId/{recordId}")
	public ResponseEntity<ResponseStructure<MedicalRecord>> fetchMedicalRecordByUsingRecordId(@PathVariable Integer recordId){
		return medicalRecordService.fetchMedicalRecordByUsingRecordId(recordId);
	}
	
	//Fetch Medical Record By Using VisitDate
	@GetMapping("/visitDate/{visitDate}")
	public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchMedicalRecordByUsingVisitDate(@PathVariable LocalDate visitDate){
		return medicalRecordService.fetchMedicalRecordByUsingVisitDate(visitDate);
	}
	
	//Fetch Medical Record By Using PatientId
	@GetMapping("/patientId/{patientId}")
	public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchMedicalRecordByUsingPatientId(@PathVariable Integer patientId){
		return medicalRecordService.fetchMedicalRecordByUsingPatientId(patientId);
	}
	
	//Fetch Medical Record By Using DoctorId
	@GetMapping("/doctorId/{doctorId}")
	public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchMedicalRecordByUsingDoctorId(@PathVariable Integer doctorId){
		return medicalRecordService.fetchMedicalRecordByUsingDoctorId(doctorId);
	}
	
	//Fetch Medical Record By Using AppointmentId
	@GetMapping("/appointmentId/{appointmentId}")
	public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchMedicalRecordByUsingAppointmentId(@PathVariable Integer appointmentId){
		return medicalRecordService.fetchMedicalRecordByUsingAppointmentId(appointmentId);
	}
}
















