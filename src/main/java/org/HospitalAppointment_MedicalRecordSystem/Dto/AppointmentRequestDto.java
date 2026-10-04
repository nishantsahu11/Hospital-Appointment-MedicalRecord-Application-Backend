package org.HospitalAppointment_MedicalRecordSystem.Dto;

import java.time.LocalDateTime;

import org.HospitalAppointment_MedicalRecordSystem.Entity.AppointmentStatus;

public class AppointmentRequestDto {

	private LocalDateTime appointmentDateTime;
	private AppointmentStatus appointmentStatus;
	private Long doctorId;
	private Integer patientId;
	
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
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	
	
}
