package org.HospitalAppointment_MedicalRecordSystem.Service;

import java.util.List;

import org.HospitalAppointment_MedicalRecordSystem.Dao.DoctorDao;
import org.HospitalAppointment_MedicalRecordSystem.Dto.DoctorRequestDto;
import org.HospitalAppointment_MedicalRecordSystem.Dto.DoctorUpdateDto;
import org.HospitalAppointment_MedicalRecordSystem.Dto.ResponseStructure;
import org.HospitalAppointment_MedicalRecordSystem.Entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

	@Autowired
	private DoctorDao doctorDao;
	
	//Save Doctor Record
	public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(DoctorRequestDto dto) {
		ResponseStructure<Doctor> resp = new ResponseStructure<Doctor>();
		resp.setStatusCode(HttpStatus.CREATED.value());
		resp.setMessage("Doctor Record Had Been Inserted In DB!");
		resp.setData(doctorDao.saveDoctor(dto));
		return new ResponseEntity<ResponseStructure<Doctor>>(resp,HttpStatus.CREATED);
	}

	//Fetch All Doctor Record 
	public ResponseEntity<ResponseStructure<List<Doctor>>> fetchAllDoctor() {
		ResponseStructure<List<Doctor>> resp = new ResponseStructure<List<Doctor>>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("All Doctor Record had Been Displayed Form DB!");
		resp.setData(doctorDao.fetchAllDoctor());
		
		return new ResponseEntity<ResponseStructure<List<Doctor>>>(resp,HttpStatus.FOUND);
	}

	//Fetch Doctor Record By Using DoctorId
	public ResponseEntity<ResponseStructure<Doctor>> fetchDoctorByUsingId(Long doctorId) {
		ResponseStructure<Doctor> resp = new ResponseStructure<Doctor>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Doctor Record With Id: "+doctorId+" Had Been Found From DB!");
		resp.setData(doctorDao.fetchDoctorByUsingId(doctorId));
		
		return new ResponseEntity<ResponseStructure<Doctor>>(resp,HttpStatus.FOUND);
	}


	//Fetch Doctor Record By Using Specialization
	public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorByUsingSpecialization(String specialization) {
		ResponseStructure<List<Doctor>> resp = new ResponseStructure<List<Doctor>>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Doctor Record With Specialization: "+specialization+" Had Been Found Form DB!");
		resp.setData(doctorDao.fetchDoctorByUsingSpecialization(specialization));
		
		return new ResponseEntity<ResponseStructure<List<Doctor>>>(resp,HttpStatus.FOUND);
	}

	//Fetch Doctor Record By Using DepartmentId
	public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorByUsingDepartmentId(Integer departmentId) {
		ResponseStructure<List<Doctor>> resp = new ResponseStructure<List<Doctor>>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Doctor Record With DepartmentId: "+departmentId+" Had Been Found From DB!");
		resp.setData(doctorDao.fetchDoctorByUsingDepartmentId(departmentId));
		
		return new ResponseEntity<ResponseStructure<List<Doctor>>>(resp,HttpStatus.FOUND);
	}
	
	//Fetch Doctor Record By Using PatientId
	public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorByUsingPatientId(Integer patientId) {
		ResponseStructure<List<Doctor>> resp = new ResponseStructure<List<Doctor>>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Doctor Record Had Been Found For PatientId: "+patientId+" From DB!");
		resp.setData(doctorDao.fetchDoctorByUsingPatientId(patientId));
		
		return new ResponseEntity<ResponseStructure<List<Doctor>>>(resp,HttpStatus.FOUND);
	}

	//Fetch Doctor Record By Using AppointmentId
	public ResponseEntity<ResponseStructure<Doctor>> fetchDoctorByUsingappointmentId(Integer appointmentId) {
		ResponseStructure<Doctor> resp = new ResponseStructure<Doctor>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Doctor Record Had Been Found For AppointmentId: "+appointmentId+" From DB!");
		resp.setData(doctorDao.fetchDoctorByUsingappointmentId(appointmentId));
		
		return new ResponseEntity<ResponseStructure<Doctor>>(resp,HttpStatus.FOUND);
	}

	//Fetch Doctor Record By Using AvailableDays
	public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorByUsingAvailableDays(String availableDays) {
		ResponseStructure<List<Doctor>> resp = new ResponseStructure<List<Doctor>>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Doctor Record With AvailableDays: "+availableDays+" Had Been Found From DB!");
		resp.setData(doctorDao.fetchDoctorByUsingAvailableDays(availableDays));
		
		return new ResponseEntity<ResponseStructure<List<Doctor>>>(resp,HttpStatus.FOUND);
	}

	//Delete Doctor Record By Using DoctorId
	public ResponseEntity<ResponseStructure<String>> deleteDoctorByUsingDoctorId(Long doctorId) {
		ResponseStructure<String> resp = new ResponseStructure<String>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Doctor Record Had Been Deleted From DB!");
		resp.setData(doctorDao.deleteDoctorByUsingDoctorId(doctorId));
		
		return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.FOUND);
	}

	//Update Doctor Record By Using DoctorId
	public ResponseEntity<ResponseStructure<Doctor>> updateDoctorByUsingDoctorId(DoctorUpdateDto dto) {
		ResponseStructure<Doctor> resp = new ResponseStructure<Doctor>();
		resp.setStatusCode(HttpStatus.OK.value());
		resp.setMessage("Doctor Record With DoctorId: "+dto.getDoctorId()+" Had Been Updated In DB!");
		resp.setData(doctorDao.updateDoctorByUsingDoctorId(dto));
		
		return new ResponseEntity<ResponseStructure<Doctor>>(resp,HttpStatus.OK);
	}

	

}




























