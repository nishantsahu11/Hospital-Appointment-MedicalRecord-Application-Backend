package org.HospitalAppointment_MedicalRecordSystem.Dao;

import java.util.List;
import java.util.Optional;

import org.HospitalAppointment_MedicalRecordSystem.Entity.Department;
import org.HospitalAppointment_MedicalRecordSystem.Exception.DepartmentNameNotFoundException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.DuplicateDepartmentNameException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.IdNotFoundException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.IllegalArgumentValidException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.NoRecordAvailableException;
import org.HospitalAppointment_MedicalRecordSystem.Repositary.DepartmentRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao {

	@Autowired
	private DepartmentRepositary departmentRepositary;
	
	//Insert Single Department Record
	public Department saveDepartment(Department department) {
		boolean exist = departmentRepositary.existsByDepartmentName(department.getDepartmentName());
		if(!exist) {
			return departmentRepositary.save(department);
		}
		else {
			throw new DuplicateDepartmentNameException("Department Name "+department.getDepartmentName()+" Had Been Already Exist In DB");
		}
		
	}

	//Fetch All Department Record
	public List<Department> fetchAllDepartment() {
		List<Department> li = departmentRepositary.findAll();
		if(!li.isEmpty()) {
			return li;
		}
		else {
			throw new NoRecordAvailableException("Department Record Had Been Not Found In DB!");
		}
	}

	//Fetch Department Record By Using DepartmentId
	public Department fetchDepartmentByUsingId(Integer departmentId) {
		Optional<Department> opt = departmentRepositary.findById(departmentId);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new IdNotFoundException("Department Record With ID: "+departmentId+" Had Not Been Found In DB!");
		}
	}

	//Update Department Record By Using DepartmentId
	public Department updateDepartmentByUsingId(Department department) {
		if(department.getDepartmentId() == null) {
			throw new IllegalArgumentValidException("Department Id Must Be Pass For Update The Record In DB!");
		}
		Optional<Department> opt = departmentRepositary.findById(department.getDepartmentId());
		if(opt.isPresent()) {
			departmentRepositary.save(department);
			return opt.get();
		}
		else {
			throw new IdNotFoundException("Department Record With ID: "+department.getDepartmentId()+" Had Not Been Found In DB!");
		}
	}

	//Delete Department Record By Using DepartmentId
	public String deleteDepartmentByUsingId(Integer departmentId) {
		Optional<Department> opt = departmentRepositary.findById(departmentId);
		if(opt.isPresent()) {
			departmentRepositary.delete(opt.get());
			return "Success";
		}
		else {
			throw new IdNotFoundException("Department Record With ID: "+departmentId+" Had Not Been Found In DB!");
		}
	}

	//Fetch Department Record By Using DepartmentName
	public Department findByDepartmentByUsingDepartmentName(String departmentName) {
		Optional<Department> opt = departmentRepositary.findByDepartmentName(departmentName);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new DepartmentNameNotFoundException("Department Record With DeptName: "+departmentName+" Had Not Been Found In DB!");
		}
	}

}
