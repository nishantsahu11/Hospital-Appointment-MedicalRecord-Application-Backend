package org.HospitalAppointment_MedicalRecordSystem.Controller;

import java.util.List;

import org.HospitalAppointment_MedicalRecordSystem.Dto.ResponseStructure;
import org.HospitalAppointment_MedicalRecordSystem.Entity.Department;
import org.HospitalAppointment_MedicalRecordSystem.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	//Insert Single Department Record
	@PostMapping()
	public ResponseEntity<ResponseStructure<Department>> saveDepartment(@RequestBody Department department){
		return departmentService.saveDepartment(department);
	}
	
	//Fetch All Department Records
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Department>>> fetchAllDepartment(){
		return departmentService.fetchAllDepartment();
	}
	
	//Fetch Department By Using Id
	@GetMapping("/{departmentId}")
	public ResponseEntity<ResponseStructure<Department>> fetchDepartmentByUsingId(@PathVariable Integer departmentId){
		return departmentService.fetchDepartmentByUsingId(departmentId);
	}
	
	//Update Department Record By Using Id
	@PutMapping()
	public ResponseEntity<ResponseStructure<Department>> updateDepartmentByUsingId(@RequestBody Department department){
		return departmentService.updateDepartmentByUsingId(department);
	}
	
	//Delete Department Record By Using Id
	@DeleteMapping("/{departmentId}")
	public ResponseEntity<ResponseStructure<String>> deleteDepartmentByUsingId(@PathVariable Integer departmentId){
		return departmentService.deleteDepartmentByUsingId(departmentId);
	}
	
	//Fetch Department Record By Using DepartmentName
	@GetMapping("/departmentName/{departmentName}")
	public ResponseEntity<ResponseStructure<Department>> findByDepartmentByUsingDepartmentName(@PathVariable String departmentName){
		return departmentService.findByDepartmentByUsingDepartmentName(departmentName);
	}
}



















