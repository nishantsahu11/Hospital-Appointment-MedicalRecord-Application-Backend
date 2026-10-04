package org.HospitalAppointment_MedicalRecordSystem.Repositary;

import java.util.List;

import org.HospitalAppointment_MedicalRecordSystem.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepositary extends JpaRepository<Patient, Integer>{

	//Check the passed phoneNum already exist in DB or not
	boolean existsByphoneNumber(Long phoneNumber);
	//Check the passed email already exist in DB or not
	boolean existsByEmail(String email);
	
	//Fetch Patient Record By Using PhoneNumber
	Patient findByphoneNumber(Long phoneNumber);
	
	//Fetch Patient Record By Using PhoneNumber
	List<Patient> findBypatientAgeGreaterThan(Integer patientAge);
	
	
}
