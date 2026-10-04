package org.HospitalAppointment_MedicalRecordSystem.Entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class MedicalRecord {

	//Table Records----------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer recordId;
	private String diagonistics;
	private String treatment;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate visitDate;
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	public String getDiagonistics() {
		return diagonistics;
	}
	public void setDiagonistics(String diagonistics) {
		this.diagonistics = diagonistics;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public LocalDate getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}
	
	//Mappings----------------------------
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
	@JsonIgnore //If i remove this one then i get Doctor details at the time of fetching the Medical Record
	private Doctor doctor;
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	@ManyToOne
	@JoinColumn(name="patient_id")
	@JsonIgnore //If i remove this one then i get patient details at the time of fetching the Medical Record
	private Patient patient;
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	@OneToOne(mappedBy = "medicalRecord")
	@JsonIgnore
	private Prescription prescription;
	public Prescription getPrescription() {
		return prescription;
	}
	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}
	
}












