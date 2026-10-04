package org.HospitalAppointment_MedicalRecordSystem.Dao;

import java.util.List;
import java.util.Optional;

import org.HospitalAppointment_MedicalRecordSystem.Dto.PrescriptionRequestDto;
import org.HospitalAppointment_MedicalRecordSystem.Entity.MedicalRecord;
import org.HospitalAppointment_MedicalRecordSystem.Entity.Prescription;
import org.HospitalAppointment_MedicalRecordSystem.Exception.IdNotFoundException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.IllegalArgumentValidException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.NoRecordAvailableException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.PrescrtionAlreadyExistException;
import org.HospitalAppointment_MedicalRecordSystem.Repositary.MedicalRecordRepositary;
import org.HospitalAppointment_MedicalRecordSystem.Repositary.PatientRepositary;
import org.HospitalAppointment_MedicalRecordSystem.Repositary.PrescriptionRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PrescriptionDao {

	@Autowired
	private PrescriptionRepositary prescriptionRepositary;
	@Autowired
	private MedicalRecordRepositary medicalRecordRepositary;
	@Autowired
	private PatientRepositary patientRepositary;
	
	//Create Prescription or Insert Prescription
	public Prescription savePrescription(PrescriptionRequestDto dto) {
		if(dto.getRecordId() == null) {
			throw new IllegalArgumentValidException("Record Id Must Be Pass For Insert The Prescription In DB!");
		}
		//Check The Prescription Record Already Exist in DB for Give MedicalRecordId or Not
		boolean existPrescription = prescriptionRepositary.existsByMedicalRecordRecordId(dto.getRecordId());
		if(existPrescription) {
			throw new PrescrtionAlreadyExistException("Prescription Record Already Exists For The RecordId: "+dto.getRecordId()+" In DB!");
		}
		//Check the MedicalRecord Exist in The DB or not
		Optional<MedicalRecord> record = medicalRecordRepositary.findById(dto.getRecordId());
		//If Medical Record Exist then create Prescription Record
		if(record.isPresent()) {
			Prescription prescription = new Prescription();
			prescription.setDosage(dto.getDosage());
			prescription.setInstruction(dto.getInstruction());
			prescription.setMedicien(dto.getMedicien());
			prescription.setMedicalRecord(record.get());
			
			return prescriptionRepositary.save(prescription);
		}
		//Otherwise, throw the Exception
		else {
			throw new IdNotFoundException("Medical Record With ID: "+dto.getRecordId()+" Had Not Been Found In DB!");
		}
	}

	//Fetch All Prescription Records
	public List<Prescription> fetchAllPrescription() {
		List<Prescription> li = prescriptionRepositary.findAll();
		if(!li.isEmpty()) {
			return li;
		}
		else {
			throw new NoRecordAvailableException("Prescription Record Had Been Not Found In DB!");
		}
	}

	//Fetch Prescription Record By Using Id
	public Prescription fetchPrescriptionRecordByUsingPrescriptionId(Integer prescriptionId) {
		Optional<Prescription> opt = prescriptionRepositary.findById(prescriptionId);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new NoRecordAvailableException("Prescription Record Had Been Not Found For PrescriptionId: "+prescriptionId+" In DB!");
		}
	}

	//Fetch Prescription Record By Using medicalRecordId
	public List<Prescription> fetchPrescriptionByUsingMedicalRecordId(Integer recordId) {
		List<Prescription> li = prescriptionRepositary.findByMedicalRecordRecordId(recordId);
		if(!li.isEmpty()) {
			return li;
		}
		else {
			throw new NoRecordAvailableException("Prescription Record Had Been Not Found For MedicalRecordId: "+recordId+" In DB!");
		}
	}

	//Fetch Prescription Record By Using PatientId
	public List<Prescription> fetchPrescriptionRecordByUsingPatientId(Integer patientId) {
		List<Prescription> li = prescriptionRepositary.findByMedicalRecordPatientPatientId(patientId);
		if(!li.isEmpty()) {
			return li;
		}
		else {
			throw new NoRecordAvailableException("Prescription Record Had Been Not Found For PatientId: "+patientId+" In DB!");
		}
	}

}

























