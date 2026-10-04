package org.HospitalAppointment_MedicalRecordSystem.Repositary;

import java.util.List;
import java.util.Optional;

import org.HospitalAppointment_MedicalRecordSystem.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DoctorRepositary extends JpaRepository<Doctor, Long>{

	//Fetch Doctor Record By Using Specialization
	List<Doctor> findBySpecialization(String specialization);
	
	//Fetch Doctor Record By Using DepartmentId
	List<Doctor> findByDepartmentDepartmentId(Integer departmentId);
	
	//Fetch Doctor Record By Using AvailableDays
	List<Doctor> findByAvailableDays(String availableDays);
	
	//Fetch Doctor Record By Using AppointmentId
	@Query("""
			SELECT a.doctor
			FROM Appointment a
			WHERE a.appointmentId = :appointmentId
			""")
	Optional<Doctor> findDoctorByAppointmentId(Integer appointmentId);
}
