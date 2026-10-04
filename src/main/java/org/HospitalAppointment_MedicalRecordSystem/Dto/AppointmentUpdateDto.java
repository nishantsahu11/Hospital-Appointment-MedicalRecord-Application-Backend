package org.HospitalAppointment_MedicalRecordSystem.Dto;

import java.time.LocalDateTime;

import org.HospitalAppointment_MedicalRecordSystem.Entity.AppointmentStatus;

public class AppointmentUpdateDto {

	private Integer appointmentId;
	private AppointmentStatus appointmentStatus;
	
	public Integer getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}
	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	
}
