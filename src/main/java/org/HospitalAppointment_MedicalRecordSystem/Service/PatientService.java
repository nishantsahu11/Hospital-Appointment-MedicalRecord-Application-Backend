package org.HospitalAppointment_MedicalRecordSystem.Service;

import java.util.List;

import org.HospitalAppointment_MedicalRecordSystem.Dao.PatientDao;
import org.HospitalAppointment_MedicalRecordSystem.Dto.ResponseStructure;
import org.HospitalAppointment_MedicalRecordSystem.Entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

	@Autowired
	private PatientDao patientDao;
	
	//Insert Patient Record
	public ResponseEntity<ResponseStructure<Patient>> savePatient(Patient patient) {
		ResponseStructure<Patient> resp = new ResponseStructure<Patient>();
		resp.setStatusCode(HttpStatus.CREATED.value());
		resp.setMessage("Patient Record Had Been Inserted In DB!");
		resp.setData(patientDao.savePatient(patient));
		
		return new ResponseEntity<ResponseStructure<Patient>>(resp,HttpStatus.CREATED);
	}

	//Fetch All Patient Record
	public ResponseEntity<ResponseStructure<List<Patient>>> fetchAllPatient() {
		ResponseStructure<List<Patient>> resp = new ResponseStructure<List<Patient>>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Display All Patient Record From DB!");
		resp.setData(patientDao.fetchAllPatient());
		
		return new ResponseEntity<ResponseStructure<List<Patient>>>(resp,HttpStatus.FOUND);
	}

	//Fetch Patient Record By Using PatientId
	public ResponseEntity<ResponseStructure<Patient>> fetchPatientByUsingPatientId(Integer patientId) {
		ResponseStructure<Patient> resp = new ResponseStructure<Patient>();
		
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Patient Record With PatientId: "+patientId+" Had Been Found From DB!");
		resp.setData(patientDao.fetchPatientByUsingPatientId(patientId));
		
		return new ResponseEntity<ResponseStructure<Patient>>(resp,HttpStatus.FOUND);
	}

	//Fetch Patient Record By Using PhoneNumber
	public ResponseEntity<ResponseStructure<Patient>> fetchPatientByUsingPhoneNumber(Long phoneNumber) {
		ResponseStructure<Patient> resp = new ResponseStructure<Patient>();
		
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Patient Record With PhoneNum: "+phoneNumber+" Had Been Found From DB!");
		resp.setData(patientDao.fetchPatientByUsingPatientId(phoneNumber));
		
		return new ResponseEntity<ResponseStructure<Patient>>(resp,HttpStatus.FOUND);
	}

	//Fetch Patient Record where Age is GreaterThan
	public ResponseEntity<ResponseStructure<List<Patient>>> fetchPatientWhereAgeIsGreaterThan(Integer patientAge) {
		ResponseStructure<List<Patient>> resp = new ResponseStructure<List<Patient>>();
		
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Patient Record Had Been Found For Age Greater Than Is "+patientAge+" From DB!");
		resp.setData(patientDao.fetchPatientWhereAgeIsGreaterThan(patientAge));
		
		return new ResponseEntity<ResponseStructure<List<Patient>>>(resp,HttpStatus.FOUND);
	}
	
	//Fetch Patient Record By Using AppointmentId
	public ResponseEntity<ResponseStructure<Patient>> fetchPatientRecordByUsingAppointmentId(
			Integer appointmentId) {
		ResponseStructure<Patient> resp = new ResponseStructure<Patient>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Patient Record Had Been Found For AppointmentId: "+appointmentId+" From DB!");
		resp.setData(patientDao.fetchPatientRecordByUsingAppointmentId(appointmentId));
		
		return new ResponseEntity<ResponseStructure<Patient>>(resp,HttpStatus.FOUND);
	
	}

	//Fetch Patient Record By Using MedicalRecordId
	public ResponseEntity<ResponseStructure<Patient>> fetchPatientRecordByUsingMedicalRecordId(Integer recordId) {
		ResponseStructure<Patient> resp = new ResponseStructure<Patient>();
		
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Patient Record Had Been Found For MedicalRecordId: "+recordId+" From DB!");
		resp.setData(patientDao.fetchPatientRecordByUsingMedicalRecordId(recordId));
		
		return new ResponseEntity<ResponseStructure<Patient>>(resp,HttpStatus.FOUND);
	}

	//Delete Patient Record By Using PatientId
	public ResponseEntity<ResponseStructure<String>> deletePatientByUsingPatientId(Integer patientId) {
		ResponseStructure<String> resp = new ResponseStructure<String>();
		resp.setStatusCode(HttpStatus.OK.value());
		resp.setMessage("Patient Record With PatientId: "+patientId+" Had Been Deleted From DB!");
		resp.setData(patientDao.deletePatientByUsingPatientId(patientId));
		
		return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.OK);
	}

	//Update Patient Record By Using PatientId
	public ResponseEntity<ResponseStructure<Patient>> updatePatientByUsingPatientId(Patient patient) {
		
		ResponseStructure<Patient> resp = new ResponseStructure<Patient>();
		
		resp.setStatusCode(HttpStatus.OK.value());
		resp.setMessage("Patient Record With PatientId: "+patient.getPatientId()+" Had Been Updated In DB!");
		resp.setData(patientDao.updatePatientByUsingPatientId(patient));
		
		return new ResponseEntity<ResponseStructure<Patient>>(resp,HttpStatus.OK);
	}

	

}




















