package org.HospitalAppointment_MedicalRecordSystem.Repositary;

import java.util.List;

import org.HospitalAppointment_MedicalRecordSystem.Entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepositary extends JpaRepository<Prescription, Integer>{

	//Check The Prescription Record Already Exist in DB for Give MedicalRecordId or Not
	boolean existsByMedicalRecordRecordId(Integer recordId);
	
	//Fetch Prescription Record By Using RecordId
	List<Prescription> findByMedicalRecordRecordId(Integer recordId);
	
	//Fetch Prescription Record By Using PatientId
	List<Prescription> findByMedicalRecordPatientPatientId(Integer patientId);
}
