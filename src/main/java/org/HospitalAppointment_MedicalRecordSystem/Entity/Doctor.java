package org.HospitalAppointment_MedicalRecordSystem.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Doctor {

	//Table Records------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long doctorId;
	private String doctorName;
	private String specialization;
//	@ElementCollection //If i used this annotation then the days not insert in DB, and if we do not used this we don't find the doctor record on AvailableDays 
	private List<String> availableDays;
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public List<String> getAvailableDays() {
		return availableDays;
	}
	public void setAvailableDays(List<String> availableDays) {
		this.availableDays = availableDays;
	}
	
	//Mapping----------------------
	//ManyToOne mapping from Doctor to Department
	@ManyToOne
	@JoinColumn(name="department_id")
	@JsonIgnore
	private Department department;
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	//OneToMany mapping from Doctor to Appointment
	@OneToMany(mappedBy = "doctor")
	@JsonIgnore
	private List<Appointment> appointments;
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	//OneToMany mapping from Doctor to MedicalRecord
	@OneToMany(mappedBy = "doctor")
	@JsonIgnore
	private List<MedicalRecord> medicalRecords;
	public List<MedicalRecord> getMedicalRecords() {
		return medicalRecords;
	}
	public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}
	
	
	
}
