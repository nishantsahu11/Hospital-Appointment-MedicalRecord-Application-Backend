package org.HospitalAppointment_MedicalRecordSystem.Controller;

import java.util.List;

import org.HospitalAppointment_MedicalRecordSystem.Dto.DoctorRequestDto;
import org.HospitalAppointment_MedicalRecordSystem.Dto.DoctorUpdateDto;
import org.HospitalAppointment_MedicalRecordSystem.Dto.ResponseStructure;
import org.HospitalAppointment_MedicalRecordSystem.Entity.Doctor;
import org.HospitalAppointment_MedicalRecordSystem.Service.DoctorService;
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
@RequestMapping("doctor")
public class DoctorController {

	@Autowired 
	private DoctorService doctorService;
	
	//Insert Doctor Record
	@PostMapping()
	public ResponseEntity<ResponseStructure<Doctor>> saveDoctar(@RequestBody DoctorRequestDto dto){
		return doctorService.saveDoctor(dto);
	}
	
	//Fetch All Doctor Records
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Doctor>>> fetchAllDoctor(){
		return doctorService.fetchAllDoctor();
	}
	
	//Fetch Doctor Record By Using Id
	@GetMapping("/{doctorId}")
	public ResponseEntity<ResponseStructure<Doctor>> fetchDoctorByUsingId(@PathVariable Long doctorId){
		return doctorService.fetchDoctorByUsingId(doctorId);
	}
	
	//Fetch Doctor Record By Using Specialization 
	@GetMapping("/specialization/{specialization}")
	public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorByUsingSpecialization(@PathVariable String specialization){
		return doctorService.fetchDoctorByUsingSpecialization(specialization);
	}
	
	//Fetch Doctor Record By Using DepartmentId
	@GetMapping("/departmentId/{departmentId}")
	public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorByUsingDepartmentId(@PathVariable Integer departmentId){
		return doctorService.fetchDoctorByUsingDepartmentId(departmentId);
	}
	
	//Fetch Doctor Record By Using PatientId
	@GetMapping("/patientId/{patientId}")
	public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorByUsingPatientId(@PathVariable Integer patientId){
		return doctorService.fetchDoctorByUsingPatientId(patientId);
	}
		
	//Fetch Doctor Record By Using AppointmentId
	@GetMapping("/appointmentId/{appointmentId}")
	public ResponseEntity<ResponseStructure<Doctor>> fetchDoctorByUsingappointmentId(@PathVariable Integer appointmentId){
		return doctorService.fetchDoctorByUsingappointmentId(appointmentId);
	}
	
	//Fetch Doctor Record By Using findByAvailableDays
	@GetMapping("/availableDays/{availableDays}")
	public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorByUsingAvailableDays(@PathVariable String availableDays){
		return doctorService.fetchDoctorByUsingAvailableDays(availableDays);
	}
	
	//Delete Doctor Record By Using DoctorID
	@DeleteMapping("/doctorId/{doctorId}")
	public ResponseEntity<ResponseStructure<String>> deleteDoctorByUsingDoctorId(@PathVariable Long doctorId){
		return doctorService.deleteDoctorByUsingDoctorId(doctorId);
	}
	
	//Update Doctor Record By Using DoctorId
	@PutMapping()
	public ResponseEntity<ResponseStructure<Doctor>> updateDoctorByUsingDoctorId(@RequestBody DoctorUpdateDto dto){
		return doctorService.updateDoctorByUsingDoctorId(dto);
	}
	
	
}



