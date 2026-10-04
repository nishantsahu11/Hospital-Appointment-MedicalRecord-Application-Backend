package org.HospitalAppointment_MedicalRecordSystem.Dto;

import java.util.List;

public class DoctorRequestDto {

	private String doctorName;
	private String specialization;
	private List<String> availableDays;
	private Integer departmentId;
	
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
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	
	
}
