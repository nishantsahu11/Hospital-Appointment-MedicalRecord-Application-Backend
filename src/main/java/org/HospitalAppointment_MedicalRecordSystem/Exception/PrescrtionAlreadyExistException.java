package org.HospitalAppointment_MedicalRecordSystem.Exception;

//import org.HospitalAppointment_MedicalRecordSystem.Dao.PrescrtionAlreadyExistException;

public class PrescrtionAlreadyExistException extends RuntimeException{

	public PrescrtionAlreadyExistException(String msg) {
		super(msg);
	}
}
