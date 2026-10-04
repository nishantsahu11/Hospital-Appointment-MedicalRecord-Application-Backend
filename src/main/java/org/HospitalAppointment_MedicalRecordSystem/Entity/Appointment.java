package org.HospitalAppointment_MedicalRecordSystem.Entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Appointment {

	//Table Records----------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appointmentId;
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")       // JSON
//	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")  // FORM DATA
	private LocalDateTime appointmentDateTime;
	@Enumerated(EnumType.STRING)
	private AppointmentStatus appointmentStatus;
	
	public Integer getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
	public LocalDateTime getAppointmentDateTime() {
		return appointmentDateTime;
	}
	public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
		this.appointmentDateTime = appointmentDateTime;
	}
	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}
	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	
	//Mappings--------------------------
	//ManyToOne
	@ManyToOne
	@JoinColumn(name="patient_id")
	@JsonIgnore //If i remove this one then i get patient details at the time of fetching the Appointment 
	private Patient patient;
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@ManyToOne
	@JoinColumn(name="doctor_id")
	@JsonIgnore //If i remove this one then i get Doctor details at the time of fetching the Appointment 
	private Doctor doctor;

	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctors(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
}
