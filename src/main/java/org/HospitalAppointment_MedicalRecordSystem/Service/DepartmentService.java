package org.HospitalAppointment_MedicalRecordSystem.Service;

import java.util.List;

import org.HospitalAppointment_MedicalRecordSystem.Dao.DepartmentDao;
import org.HospitalAppointment_MedicalRecordSystem.Dto.ResponseStructure;
import org.HospitalAppointment_MedicalRecordSystem.Entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;
	
	//Insert Department Record
	public ResponseEntity<ResponseStructure<Department>> saveDepartment(Department department) {
		ResponseStructure<Department> resp = new ResponseStructure<Department>();
		resp.setStatusCode(HttpStatus.CREATED.value());
		resp.setMessage("Department Record had Been Inserted In DB!");
		resp.setData(departmentDao.saveDepartment(department));
		
		return new ResponseEntity<ResponseStructure<Department>>(resp,HttpStatus.CREATED);
	}

	//Fetch All Department Record
	public ResponseEntity<ResponseStructure<List<Department>>> fetchAllDepartment() {
		ResponseStructure<List<Department>> resp = new ResponseStructure<List<Department>>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("All Department Record Had Been Display From DB!");
		resp.setData(departmentDao.fetchAllDepartment());
		
		return new ResponseEntity<ResponseStructure<List<Department>>>(resp,HttpStatus.FOUND);
	}

	//Fetch Department Record By Using DepartmentId
	public ResponseEntity<ResponseStructure<Department>> fetchDepartmentByUsingId(Integer departmentId) {
		ResponseStructure<Department> resp = new ResponseStructure<Department>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Found!");
		resp.setData(departmentDao.fetchDepartmentByUsingId(departmentId));
		
		return new ResponseEntity<ResponseStructure<Department>>(resp,HttpStatus.FOUND);
	}

	//Update Department Record By Using DepartmentId
	public ResponseEntity<ResponseStructure<Department>> updateDepartmentByUsingId(Department department) {
		ResponseStructure<Department> resp = new ResponseStructure<Department>();
		resp.setStatusCode(HttpStatus.OK.value());
		resp.setMessage("Found!");
		resp.setData(departmentDao.updateDepartmentByUsingId(department));
		
		return new ResponseEntity<ResponseStructure<Department>>(resp,HttpStatus.OK);
	}

	//Delete Department Record By Using DepartmentId
	public ResponseEntity<ResponseStructure<String>> deleteDepartmentByUsingId(Integer departmentId) {
		ResponseStructure<String> resp = new ResponseStructure<String>();
		resp.setStatusCode(HttpStatus.OK.value());
		resp.setMessage("Department Record With Id: "+departmentId+" Had Been Deleted From DB!");
		resp.setData(departmentDao.deleteDepartmentByUsingId(departmentId));
		
		return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.OK);
	}

	//Fetch Department Record By Using DepartmentName
	public ResponseEntity<ResponseStructure<Department>> findByDepartmentByUsingDepartmentName(String departmentName) {
		ResponseStructure<Department> resp = new ResponseStructure<Department>();
		resp.setStatusCode(HttpStatus.OK.value());
		resp.setMessage("Department Record Had Been Found From DB!");
		resp.setData(departmentDao.findByDepartmentByUsingDepartmentName(departmentName));
		
		return new ResponseEntity<ResponseStructure<Department>>(resp,HttpStatus.OK);
	}

}
