package org.HospitalAppointment_MedicalRecordSystem.Repositary;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.HospitalAppointment_MedicalRecordSystem.Entity.Appointment;
import org.HospitalAppointment_MedicalRecordSystem.Entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicalRecordRepositary extends JpaRepository<MedicalRecord, Integer>{

	//Check The GIven Medical Record Already Exist For Appointment in DB or Not
	boolean existsByPatientPatientIdAndDoctorDoctorIdAndVisitDate(Integer patientId,Long doctorId, LocalDate visitDate);
	
	//Fetch Medical Record By Using visitDate
	List<MedicalRecord> findByvisitDate(LocalDate visitDate);
	
	//Fetch Medical Record By Using PatientId (Direct relation is Available)
	List<MedicalRecord> findByPatientPatientId(Integer patientId);
	
	//Fetch Medical Record By Using DoctorId (Direct relation is Available)
	List<MedicalRecord> findByDoctorDoctorId(Integer doctorId);
	
	//Fetch Medical Record By Using AppointmentId (direct relation is not there so: MedicalRecord->Patient->Appointment)
	@Query("""
			SELECT m FROM MedicalRecord m
			WHERE m.patient.patientId = 
			(SELECT a.patient.patientId
			FROM Appointment a
			WHERE a.appointmentId = :appointmentId)
			""")
	List<MedicalRecord> findMedicalRecordPAppointmentId(Integer appointmentId);
}
