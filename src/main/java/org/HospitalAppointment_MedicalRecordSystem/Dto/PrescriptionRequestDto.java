package org.HospitalAppointment_MedicalRecordSystem.Dto;

public class PrescriptionRequestDto {

	private String medicien;
	private String dosage;
	private String instruction;
	private Integer recordId;
	
	public String getMedicien() {
		return medicien;
	}
	public void setMedicien(String medicien) {
		this.medicien = medicien;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	
	
}
