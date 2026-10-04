package org.HospitalAppointment_MedicalRecordSystem.Service;

import java.time.LocalDate;
import java.util.List;

import org.HospitalAppointment_MedicalRecordSystem.Dao.MedicalRecordDao;
import org.HospitalAppointment_MedicalRecordSystem.Dto.MedicalRecordRequestDto;
import org.HospitalAppointment_MedicalRecordSystem.Dto.ResponseStructure;
import org.HospitalAppointment_MedicalRecordSystem.Entity.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService {
	
	@Autowired
	private MedicalRecordDao medicalRecordDao;

	//Create Record or Insert Record
	public ResponseEntity<ResponseStructure<MedicalRecord>> saveMedicalRecord(MedicalRecordRequestDto dto) {
		ResponseStructure<MedicalRecord> resp = new ResponseStructure<MedicalRecord>();
		resp.setStatusCode(HttpStatus.CREATED.value());
		resp.setMessage("Medical Record Had Been Created For PatientId: "+dto.getPatientId()+" and DoctorId: "+dto.getDoctorId()+" On The VisitDate: "+dto.getVisitDate()+" In DB!");
		resp.setData(medicalRecordDao.saveMedicalRecord(dto));
		
		return new ResponseEntity<ResponseStructure<MedicalRecord>>(resp, HttpStatus.CREATED);
	}

	//Fetch All The Medical Record
	public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchAllMedicalRecord() {
		ResponseStructure<List<MedicalRecord>> resp = new ResponseStructure<List<MedicalRecord>>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Display All The Medical Record From DB!");
		resp.setData(medicalRecordDao.fetchAllMedicalRecord());
		
		return new ResponseEntity<ResponseStructure<List<MedicalRecord>>>(resp,HttpStatus.FOUND);
	}

	//Fetch Medical Record By Using RecordId
	public ResponseEntity<ResponseStructure<MedicalRecord>> fetchMedicalRecordByUsingRecordId(Integer recordId) {
		ResponseStructure<MedicalRecord> resp = new ResponseStructure<MedicalRecord>();
		
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Medical Record Had Been Found For RecordId: "+recordId+" From DB!");
		resp.setData(medicalRecordDao.fetchMedicalRecordByUsingRecordId(recordId));
		
		return new ResponseEntity<ResponseStructure<MedicalRecord>>(resp,HttpStatus.FOUND);
	}

	//Fetch Medical Record By Using visitDate
	public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchMedicalRecordByUsingVisitDate(LocalDate visitDate) {
		ResponseStructure<List<MedicalRecord>> resp = new ResponseStructure<List<MedicalRecord>>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Medical Record Had Been Found For VisitDate: "+visitDate+" In DB");
		resp.setData(medicalRecordDao.fetchMedicalRecordByUsingVisitDate(visitDate));
		
		return new ResponseEntity<ResponseStructure<List<MedicalRecord>>>(resp,HttpStatus.FOUND);
	}

	//Fetch Medical Record By Using PatientId
	public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchMedicalRecordByUsingPatientId(
			Integer patientId) {
		ResponseStructure<List<MedicalRecord>> resp = new ResponseStructure<List<MedicalRecord>>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Medical Record Had Been Found For PatientId: "+patientId+" In DB");
		resp.setData(medicalRecordDao.fetchMedicalRecordByUsingPatientId(patientId));
		
		return new ResponseEntity<ResponseStructure<List<MedicalRecord>>>(resp,HttpStatus.FOUND);
	
	}

	//Fetch Medical Record By Using DoctorId
	public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchMedicalRecordByUsingDoctorId(Integer doctorId) {
		ResponseStructure<List<MedicalRecord>> resp = new ResponseStructure<List<MedicalRecord>>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Medical Record Had Been Found For DoctorId: "+doctorId+" In DB");
		resp.setData(medicalRecordDao.fetchMedicalRecordByUsingDoctorId(doctorId));
		
		return new ResponseEntity<ResponseStructure<List<MedicalRecord>>>(resp,HttpStatus.FOUND);
	}

	//Fetch Medical Record By Using AppointmentId
	public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchMedicalRecordByUsingAppointmentId(
			Integer appointmentId) {
		ResponseStructure<List<MedicalRecord>> resp = new ResponseStructure<List<MedicalRecord>>();
		resp.setStatusCode(HttpStatus.FOUND.value());
		resp.setMessage("Medical Record Had Been Found For AppointmentId: "+appointmentId+" In DB");
		resp.setData(medicalRecordDao.fetchMedicalRecordByUsingAppointmentId(appointmentId));
		
		return new ResponseEntity<ResponseStructure<List<MedicalRecord>>>(resp,HttpStatus.FOUND);
	}

	
	
}



























