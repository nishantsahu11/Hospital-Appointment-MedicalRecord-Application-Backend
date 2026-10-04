package org.HospitalAppointment_MedicalRecordSystem.Repositary;

import java.util.List;
import java.util.Optional;

import org.HospitalAppointment_MedicalRecordSystem.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepositary extends JpaRepository<Department, Integer>{
	
	//Check THe Given DepartmentName Already Exist In DB or Not
	boolean existsByDepartmentName(String departmentName);
	
	//Fetch All Record based On DepartmentName
	Optional<Department> findByDepartmentName(String departmentName);
}
