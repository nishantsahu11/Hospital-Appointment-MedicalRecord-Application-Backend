package org.HospitalAppointment_MedicalRecordSystem.Controller;

import java.util.List;

import org.HospitalAppointment_MedicalRecordSystem.Dto.PrescriptionRequestDto;
import org.HospitalAppointment_MedicalRecordSystem.Dto.ResponseStructure;
import org.HospitalAppointment_MedicalRecordSystem.Entity.Prescription;
import org.HospitalAppointment_MedicalRecordSystem.Service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("prescription")
public class PrescriptionController {

	@Autowired
	private PrescriptionService prescriptionService;
	
	//Create Prescription or Insert Prescription
	@PostMapping()
	public ResponseEntity<ResponseStructure<Prescription>> savePrescription(@RequestBody PrescriptionRequestDto dto){
		return prescriptionService.savePrescription(dto);
	}
	
	//Fetch All Prescription
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Prescription>>> fetchAllPrescription(){
		return prescriptionService.fetchAllPrescription();
	}
	
	//Fetch Prescription Record By Using Id
	@GetMapping("/prescriptionId/{prescriptionId}")
	public ResponseEntity<ResponseStructure<Prescription>> fetchPrescriptionRecordByUsingPrescriptionId(@PathVariable Integer prescriptionId){
		return prescriptionService.fetchPrescriptionRecordByUsingPrescriptionId(prescriptionId);
	}
	
	//Fetch Prescription Record By Using MedicalRecord Id
	@GetMapping("/medicalrecordId/{recordId}")
	public ResponseEntity<ResponseStructure<List<Prescription>>> fetchPrescriptionByUsingMedicalRecordId(@PathVariable Integer recordId){
		return prescriptionService.fetchPrescriptionByUsingMedicalRecordId(recordId);
	}
	
	//Fetch Prescription Record By Using PatientId
	@GetMapping("/patientId/{patientId}")
	public ResponseEntity<ResponseStructure<List<Prescription>>> fetchPrescriptionRecordByUsingPatientId(@PathVariable Integer patientId){
		return prescriptionService.fetchPrescriptionRecordByUsingPatientId(patientId);
	}
}



















