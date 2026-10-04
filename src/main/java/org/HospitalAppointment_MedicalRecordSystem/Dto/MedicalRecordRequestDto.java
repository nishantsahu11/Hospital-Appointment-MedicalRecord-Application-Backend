package org.HospitalAppointment_MedicalRecordSystem.Dto;

import java.time.LocalDate;

public class MedicalRecordRequestDto {

	private String diagonistics;
	private String treatment;
	private LocalDate visitDate;
	private Long doctorId;
	private Integer patientId;
	
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
