package org.HospitalAppointment_MedicalRecordSystem.Dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.HospitalAppointment_MedicalRecordSystem.Dto.DoctorRequestDto;
import org.HospitalAppointment_MedicalRecordSystem.Dto.DoctorUpdateDto;
import org.HospitalAppointment_MedicalRecordSystem.Entity.Appointment;
//import org.HospitalAppointment_MedicalRecordSystem.Dto.DoctorRequestDto;
import org.HospitalAppointment_MedicalRecordSystem.Entity.Department;
import org.HospitalAppointment_MedicalRecordSystem.Entity.Doctor;
import org.HospitalAppointment_MedicalRecordSystem.Exception.DepartmentIdNotFoundException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.IdNotFoundException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.IllegalArgumentValidException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.NoRecordAvailableException;
import org.HospitalAppointment_MedicalRecordSystem.Exception.SpecializationNotFoundException;
import org.HospitalAppointment_MedicalRecordSystem.Repositary.AppointmentRepositary;
import org.HospitalAppointment_MedicalRecordSystem.Repositary.DepartmentRepositary;
import org.HospitalAppointment_MedicalRecordSystem.Repositary.DoctorRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorDao {

	@Autowired
	private DoctorRepositary doctorRepositary;
	@Autowired
	private DepartmentRepositary departmentRepositary;
	@Autowired
	private AppointmentRepositary appointmentRepositary;
	
	//Save Doctor Record
	public Doctor saveDoctor(DoctorRequestDto dto) {
		Optional<Department> opt = departmentRepositary.findById(dto.getDepartmentId());
		if(opt.isPresent()) {
			Doctor doctor = new Doctor();
			doctor.setDoctorName(dto.getDoctorName());
			doctor.setSpecialization(dto.getSpecialization());
			doctor.setAvailableDays(dto.getAvailableDays());
			doctor.setDepartment(opt.get());
			
			return doctorRepositary.save(doctor);
		}
		else {
			throw new DepartmentIdNotFoundException("Department Record With DeptName: "+dto.getDepartmentId()+" Had Not Been Found In DB!");
		}
	}

	//Fetch All Doctor Record
	public List<Doctor> fetchAllDoctor() {
		List<Doctor> li = doctorRepositary.findAll();
		if(!li.isEmpty()) {
			return li;
		}
		else {
			throw new NoRecordAvailableException("Doctor Record Had Been Not Found In DB!");
		}
	}

	//Fetch Doctor Record By Using DoctorId
	public Doctor fetchDoctorByUsingId(Long doctorId) {
		Optional<Doctor> opt = doctorRepositary.findById(doctorId);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new IdNotFoundException("Doctor Record With ID: "+doctorId+" Had Not Been Found In DB!");
		}
	}

	//Fetch Doctor Record By Using Specialization
	public List<Doctor> fetchDoctorByUsingSpecialization(String specialization) {
		List<Doctor> li = doctorRepositary.findBySpecialization(specialization);
		if(!li.isEmpty()) {
			return li;
		}
		else {
			throw new SpecializationNotFoundException("Doctor Record With Specialization: "+specialization+" Had Been not Found In DB!");
		}
	}

	//Fetch Doctor Record By Using DepartmentId
	public List<Doctor> fetchDoctorByUsingDepartmentId(Integer departmentId) {
		Optional<Department> opt = departmentRepositary.findById(departmentId);
		if(opt.isPresent()) {
			return doctorRepositary.findByDepartmentDepartmentId(departmentId);
		}
		else {
			throw new DepartmentIdNotFoundException("Department Record With DeptID: "+departmentId+" Had Not Been Found In DB!");
		}
	}
	
	//Fetch Doctor Record By Using PatientId
	public List<Doctor> fetchDoctorByUsingPatientId(Integer patientId) {
		List<Appointment> appointments = appointmentRepositary.findByPatientPatientId(patientId); //Find All Appointment for the given PatientId
		if(!appointments.isEmpty()) {
			Set<Doctor> doctorSet = new HashSet<>(); //Don't contain Duplicate Record For Doctor
			for(Appointment ap: appointments) {
				doctorSet.add(ap.getDoctor());
			}
			return new ArrayList<>(doctorSet);
		}
		else {
			throw new NoRecordAvailableException("Doctor Record Had Been Not Found For PatientId: "+patientId+" From DB!");
		}
	}

	//Fetch Doctor Record By Using AppointmentId
	public Doctor fetchDoctorByUsingappointmentId(Integer appointmentId) {
		Optional<Doctor> opt = doctorRepositary.findDoctorByAppointmentId(appointmentId);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new IdNotFoundException("Doctor Record Had Not Been Found For AppointmentId: "+appointmentId+" In DB!");
		}
	}

	//Fetch Doctor Record By Using AvailableDay
	public List<Doctor> fetchDoctorByUsingAvailableDays(String availableDays) {
		List<Doctor> li = doctorRepositary.findByAvailableDays(availableDays);
		if(!li.isEmpty()) {
			return li;
		}
		else {
			throw new NoRecordAvailableException("Doctor Record With AvailableDays: "+availableDays+" Had Been Not Found In DB!");
		}
	}

	//Delete Doctor Record By Using DoctorId
	public String deleteDoctorByUsingDoctorId(Long doctorId) {
		Optional<Doctor> opt = doctorRepositary.findById(doctorId);
		if(opt.isPresent()) {
			Doctor doctor = opt.get();
			doctor.getAvailableDays().clear();
			doctorRepositary.delete(doctor);
			return "Success!";
		}
		else {
			throw new IdNotFoundException("Doctor Record With ID: "+doctorId+" Had Not Been Found In DB!");
		}
	}

	//Update Doctor Record By Using DoctorId
	public Doctor updateDoctorByUsingDoctorId(DoctorUpdateDto dto) {
		if(dto.getDoctorId()==null) {
			throw new IllegalArgumentValidException("Patient Id Must Be Pass For Update The Record In DB!");
		}
		Optional<Department> department = departmentRepositary.findById(dto.getDepartmentId());
		if(department.isEmpty()) {
			throw new IllegalArgumentValidException("Department Id Must Be Pass For Update The Record In DB!");
		}
		Optional<Doctor> opt = doctorRepositary.findById(dto.getDoctorId());
		if(opt.isPresent()) {
			Doctor doctor = opt.get();
			doctor.setDoctorName(dto.getDoctorName());
			doctor.setSpecialization(dto.getSpecialization());
			doctor.setDepartment(department.get());
			;
			if(dto.getAvailableDays() != null) {
				if(doctor.getAvailableDays() == null) {
					doctor.setAvailableDays(new ArrayList<>());
				}
				else {
					Iterator<String> it = doctor.getAvailableDays().iterator();
					while(it.hasNext()) {
						it.next();
						it.remove();
					}
				}
				Iterator<String> newDays = dto.getAvailableDays().iterator();
				while(newDays.hasNext()) {
					doctor.getAvailableDays().add(newDays.next());
				}
			}
			return doctorRepositary.save(doctor);
		}
		else {
			throw new IdNotFoundException("Doctor Record With ID: "+dto.getDoctorId()+" Had Not Been Found In DB!");
		}
		

	}

	
	
	

}













