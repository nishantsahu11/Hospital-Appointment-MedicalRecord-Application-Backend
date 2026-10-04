package org.HospitalAppointment_MedicalRecordSystem.Service;

import java.util.List;

import org.HospitalAppointment_MedicalRecordSystem.Dao.PrescriptionDao;
import org.HospitalAppointment_MedicalRecordSystem.Dto.PrescriptionRequestDto;
import org.HospitalAppointment_MedicalRecordSystem.Dto.ResponseStructure;
import org.HospitalAppointment_MedicalRecordSystem.Entity.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService {

	@Autowired
	private PrescriptionDao prescriptionDao;
	
	//Create Prescription or Insert Prescription
	public ResponseEntity<ResponseStructure<Prescription>> savePrescription(PrescriptionRequestDto dto) {
		ResponseStructure<Prescription> resp = new ResponseStructure<Prescription>();
		resp.setStatusCode(HttpStatus.CREATED.value());
		resp.setMessage("Prescription Record Had Been Generated For The RecordID: "+dto.getRecordId()+" In DB!");
		resp.setData(prescriptionDao.savePrescription(dto));
		
		return new ResponseEntity<ResponseStructure<Prescription>>(resp,HttpStatus.CREATED);
	}

	//Fetch All Prescription Record
	public ResponseEntity<ResponseStructure<List<Prescription>>> fetchAllPrescription() {
		ResponseStructure<List<Prescription>> resp = new ResponseStructure<List<Prescription>>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Display All the Prescription Record From DB!");
		resp.setData(prescriptionDao.fetchAllPrescription());
		
		return new ResponseEntity<ResponseStructure<List<Prescription>>>(resp,HttpStatus.FOUND);
	}

	//FetchPrescription Record By Using prescriptionId
	public ResponseEntity<ResponseStructure<Prescription>> fetchPrescriptionRecordByUsingPrescriptionId(
			Integer prescriptionId) {
		ResponseStructure<Prescription> resp = new ResponseStructure<Prescription>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Prescription Record Had Been Found For The PrescriptionID: "+prescriptionId+" In DB!");
		resp.setData(prescriptionDao.fetchPrescriptionRecordByUsingPrescriptionId(prescriptionId));
		
		return new ResponseEntity<ResponseStructure<Prescription>>(resp,HttpStatus.FOUND);
	}

	//FetchPrescription Record By Using medicalRecordId
	public ResponseEntity<ResponseStructure<List<Prescription>>> fetchPrescriptionByUsingMedicalRecordId(
			Integer recordId) {

		ResponseStructure<List<Prescription>> resp = new ResponseStructure<List<Prescription>>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Display All the Prescription Record For MedicalRecordId: "+recordId+" From DB!");
		resp.setData(prescriptionDao.fetchPrescriptionByUsingMedicalRecordId(recordId));
		
		return new ResponseEntity<ResponseStructure<List<Prescription>>>(resp,HttpStatus.FOUND);
	}

	//FetchPrescription Record By Using PatientId
	public ResponseEntity<ResponseStructure<List<Prescription>>> fetchPrescriptionRecordByUsingPatientId(
			Integer patientId) {
		ResponseStructure<List<Prescription>> resp = new ResponseStructure<List<Prescription>>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Display All the Prescription Record For MedicalRecordId: "+patientId+" From DB!");
		resp.setData(prescriptionDao.fetchPrescriptionRecordByUsingPatientId(patientId));
		
		return new ResponseEntity<ResponseStructure<List<Prescription>>>(resp,HttpStatus.FOUND);
	}

}


















