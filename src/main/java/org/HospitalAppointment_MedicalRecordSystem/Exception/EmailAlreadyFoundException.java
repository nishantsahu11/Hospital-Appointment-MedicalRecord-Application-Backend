package org.HospitalAppointment_MedicalRecordSystem.Exception;

public class EmailAlreadyFoundException extends RuntimeException{

	public EmailAlreadyFoundException(String msg) {
		super(msg);
	}
}
