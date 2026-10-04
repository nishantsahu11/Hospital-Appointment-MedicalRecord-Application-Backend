package org.HospitalAppointment_MedicalRecordSystem.Repositary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.HospitalAppointment_MedicalRecordSystem.Entity.Appointment;
import org.HospitalAppointment_MedicalRecordSystem.Entity.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AppointmentRepositary extends JpaRepository<Appointment, Integer>{

	//Check The Same Patient can't have more than 1 Appointment on Same Day
	 @Query("SELECT a FROM Appointment a WHERE a.patient.patientId = :patientId AND a.appointmentDateTime BETWEEN :start AND :end")
	 List<Appointment> findAppointmentsForPatientOnDate(
	           Integer patientId,
	           LocalDateTime start,
	           LocalDateTime end
	    );
	 
	 //Check The Same Doctor can't have more than 1 Appointment At Same Time
	 @Query("SELECT a FROM Appointment a WHERE a.doctor.doctorId = :doctorId AND a.appointmentDateTime = :dateTime")
	 List<Appointment> findDoctorAppointmentAtSameTime(
			 Long doctorId,
			 LocalDateTime dateTime);
	 
	 //Extract THe DATE only for Fetching Appointments based On Date
	 @Query("SELECT a FROM Appointment a WHERE a.appointmentDateTime BETWEEN :start AND :end")
	 List<Appointment> findAppointmentForDate(LocalDateTime start, LocalDateTime end);
	 
	//Fetch Appointment Record By Using AppointmentStatus
	 List<Appointment> findByappointmentStatus(AppointmentStatus appointmentStatus);
	 
	//Update AppointmentStatus
	 @Modifying //Directly update only AppointmentStatus in DB
	    @Transactional
	    @Query("UPDATE Appointment a SET a.appointmentStatus = :appointmentStatus WHERE a.appointmentId = :appointmentId")
	 int updateAppointmentStatus(Integer appointmentId,AppointmentStatus appointmentStatus);
	 
	 
	 //Fetch The specified Patient Visit to the Specified Doctor On Given Date or Not
	 @Query("""
	 		SELECT a FROM Appointment a
			 WHERE a.patient.patientId = :patientId
			 AND a.doctor.doctorId = :doctorId
			 AND a.appointmentDateTime BETWEEN :start AND :end
			 """)
	 Optional<Appointment> findCompleteAppointmentForVisit(Integer patientId, Long doctorId, LocalDateTime start, LocalDateTime end);
	 
	 
	 //Fetch Appointment Record By using DoctorId
	 List<Appointment> findByDoctorDoctorId(Integer doctorId);
	 
	 //Fetch Appointment Record By using PatientId
	 List<Appointment> findByPatientPatientId(Integer patientId);
}




























