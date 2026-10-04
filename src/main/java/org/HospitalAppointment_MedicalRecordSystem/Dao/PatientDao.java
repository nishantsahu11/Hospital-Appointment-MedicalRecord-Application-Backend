package org.HospitalAppointment_MedicalRecordSystem.Dao;

import java.util.List;
import java.util.Optional;

import org.HospitalAppointment_MedicalRecordSystem.Entity.Appointment;
import org.HospitalAppointment_MedicalRecordSystem.Entity.MedicalRecord;
import org.HospitalAppointment_MedicalRecordSystem.Entity.Patient;
import org.HospitalAppointment_MedicalRecordSystem.Exception.EmailAlreadyFoundException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.IdNotFoundException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.IllegalArgumentValidException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.NoRecordAvailableException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.PhoneNumberAlreadyFoundException;
import org.HospitalAppointment_MedicalRecordSystem.Repositary.AppointmentRepositary;
import org.HospitalAppointment_MedicalRecordSystem.Repositary.MedicalRecordRepositary;
import org.HospitalAppointment_MedicalRecordSystem.Repositary.PatientRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PatientDao {

	@Autowired
	private PatientRepositary patientRepositary;
	@Autowired
	private AppointmentRepositary appointmentRepositary;
	@Autowired
	private MedicalRecordRepositary medicalRecordRepositary;
	
	//Insert Patient Record 
	public Patient savePatient(Patient patient) {
		boolean isPhoneNum = patientRepositary.existsByphoneNumber(patient.getPhoneNumber());
		boolean isEmail = patientRepositary.existsByEmail(patient.getEmail());
		if(!isPhoneNum) {
			if(!isEmail) {
				return patientRepositary.save(patient);
			}
			else {
				throw new EmailAlreadyFoundException("Email Id: "+patient.getEmail()+" Had Been Already Exists In DB!");
			}
		}
		else {
			throw new PhoneNumberAlreadyFoundException("Phone Number: ("+patient.getPhoneNumber()+") Had Been Already Exists In DB!");
		}
	}

	//Fetch All Patient Record
	public List<Patient> fetchAllPatient() {
		List<Patient> li = patientRepositary.findAll();
		if(!li.isEmpty()) {
			return li;
		}
		else {
			throw new NoRecordAvailableException("Patient Record Had Been Not Found In DB!");
		}
	}

	//Fetch Patient Record By Using PatientId
	public Patient fetchPatientByUsingPatientId(Integer patientId) {
		Optional<Patient> opt = patientRepositary.findById(patientId);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new IdNotFoundException("Patient Record With ID: "+patientId+" Had Not Been Found In DB!");
		
		}
	}

	//Fetch Patient Record By Using PhoneNumber
	public Patient fetchPatientByUsingPatientId(Long phoneNumber) {
		Patient opt = patientRepositary.findByphoneNumber(phoneNumber);
		if(opt != null) {
			return opt;
		}
		else {
			throw new IdNotFoundException("Patient Record With PhoneNum: "+phoneNumber+" Had Not Been Found In DB!");
		}
	}

	//Fetch Patient Record where Age is GreaterThan
	public List<Patient> fetchPatientWhereAgeIsGreaterThan(Integer patientAge) {
		List<Patient> li = patientRepositary.findBypatientAgeGreaterThan(patientAge);
		if(!li.isEmpty()) {
			return li;
		}
		else {
			throw new NoRecordAvailableException("Patient Record Had Been Not Found For Age Greater Than Is "+patientAge+" In DB!");
		}
	}
	
	//Fetch Patient Record By Using AppointmentId
	public Patient fetchPatientRecordByUsingAppointmentId(Integer appointmentId) {
		Optional<Appointment> appointment = appointmentRepositary.findById(appointmentId);
		if(appointment.isPresent()) {
			return appointment.get().getPatient();
		}
		else {
			throw new NoRecordAvailableException("Patient Record Had Been Not Found For AppointmentId: "+appointmentId+" In DB!");
		}
	}

	//Fetch Patient Record By Using MedicalRecordId
	public Patient fetchPatientRecordByUsingMedicalRecordId(Integer recordId) {
		Optional<MedicalRecord> record = medicalRecordRepositary.findById(recordId);
		if(record.isPresent()) {
			return record.get().getPatient();
		}
		else {
			throw new NoRecordAvailableException("Patient Record Had Been Not Found For MedicalRecordId: "+recordId+" In DB!");
		}
	}

	//Delete Patient Record By Using PatientId
	public String deletePatientByUsingPatientId(Integer patientId) {
		Optional<Patient> opt = patientRepositary.findById(patientId);
		if(opt.isPresent()) {
			patientRepositary.delete(opt.get());
			return "Success";
		}
		else {
			 
			throw new IdNotFoundException("Patient Record With PatientId: "+patientId+" Had Been Not Found In DB!");
		}
	}

	//Update Patient Record By Using PatientId
	public Patient updatePatientByUsingPatientId(Patient patient) {
		if(patient.getPatientId() == null) {
			throw new IllegalArgumentValidException("Patient Id Must Be Pass For Update The Record In DB!");
		}
		
		Optional<Patient> opt = patientRepositary.findById(patient.getPatientId());
		if(opt.isPresent()) {
			 patientRepositary.save(patient);
			 return opt.get();
		}
		else {
			throw new IdNotFoundException("Patient Record With ID: "+patient.getPatientId()+" Had Not Been Found In DB!");
		}
	}

	

}















