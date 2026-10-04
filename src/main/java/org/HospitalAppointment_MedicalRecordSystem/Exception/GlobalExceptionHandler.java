package org.HospitalAppointment_MedicalRecordSystem.Exception;

import org.HospitalAppointment_MedicalRecordSystem.Dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(NoRecordAvailableException.class)
	public ResponseEntity<ResponseStructure<String>> handleNoRecordAvailableException(NoRecordAvailableException exception){
		
		ResponseStructure<String> resp = new ResponseStructure<String>();
		resp.setStatusCode(HttpStatus.NOT_FOUND.value());
		resp.setMessage(exception.getMessage());
		resp.setData("Failure!");
		
		return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(IdNotFoundException exception){
		
		ResponseStructure<String> resp = new ResponseStructure<String>();
		resp.setStatusCode(HttpStatus.NOT_FOUND.value());
		resp.setMessage(exception.getMessage());
		resp.setData("Failure!");
		
		return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IllegalArgumentValidException.class)
	public ResponseEntity<ResponseStructure<String>> handleIllegalArgumentValidException(IllegalArgumentValidException exception){
		
		ResponseStructure<String> resp = new ResponseStructure<String>();
		resp.setStatusCode(HttpStatus.BAD_REQUEST.value());
		resp.setMessage(exception.getMessage());
		resp.setData("Failure!");
		
		return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(DuplicateDepartmentNameException.class)
	public ResponseEntity<ResponseStructure<String>> handleDuplicateDepartmentNameException(DuplicateDepartmentNameException exception){
		
		ResponseStructure<String> resp = new ResponseStructure<String>();
		resp.setStatusCode(HttpStatus.BAD_REQUEST.value());
		resp.setMessage(exception.getMessage());
		resp.setData("Failure!");
		
		return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DepartmentIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleDepartmentIdNotFoundException(DepartmentIdNotFoundException exception){
		
		ResponseStructure<String> resp = new ResponseStructure<String>();
		resp.setStatusCode(HttpStatus.NOT_FOUND.value());
		resp.setMessage(exception.getMessage());
		resp.setData("Failure!");
		
		return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DepartmentNameNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleDepartmentNameNotFoundException(DepartmentNameNotFoundException exception){
		
		ResponseStructure<String> resp = new ResponseStructure<String>();
		resp.setStatusCode(HttpStatus.NOT_FOUND.value());
		resp.setMessage(exception.getMessage());
		resp.setData("Failure!");
		
		return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SpecializationNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleSpecializationNotFoundException(SpecializationNotFoundException exception){
		
		ResponseStructure<String> resp = new ResponseStructure<String>();
		resp.setStatusCode(HttpStatus.NOT_FOUND.value());
		resp.setMessage(exception.getMessage());
		resp.setData("Failure!");
		
		return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmailAlreadyFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleEmailAlreadyFoundException(EmailAlreadyFoundException exception){
		
		ResponseStructure<String> resp = new ResponseStructure<String>();
		resp.setStatusCode(HttpStatus.BAD_REQUEST.value());
		resp.setMessage(exception.getMessage());
		resp.setData("Failure!");
		
		return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PhoneNumberAlreadyFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handlePhoneNumberAlreadyFoundException(PhoneNumberAlreadyFoundException exception){
		
		ResponseStructure<String> resp = new ResponseStructure<String>();
		resp.setStatusCode(HttpStatus.BAD_REQUEST.value());
		resp.setMessage(exception.getMessage());
		resp.setData("Failure!");
		
		return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PatientIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handlePatientIdNotFoundException(PatientIdNotFoundException exception){
		
		ResponseStructure<String> resp = new ResponseStructure<String>();
		resp.setStatusCode(HttpStatus.BAD_REQUEST.value());
		resp.setMessage(exception.getMessage());
		resp.setData("Failure!");
		
		return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DoctorIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleDoctorIdNotFoundException(DoctorIdNotFoundException exception){
		
		ResponseStructure<String> resp = new ResponseStructure<String>();
		resp.setStatusCode(HttpStatus.BAD_REQUEST.value());
		resp.setMessage(exception.getMessage());
		resp.setData("Failure!");
		
		return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MedicalRecordAlreadyFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleMedicalRecordAlreadyFoundException(MedicalRecordAlreadyFoundException exception){
		
		ResponseStructure<String> resp = new ResponseStructure<String>();
		resp.setStatusCode(HttpStatus.BAD_REQUEST.value());
		resp.setMessage(exception.getMessage());
		resp.setData("Failure!");
		
		return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PrescrtionAlreadyExistException.class)
	public ResponseEntity<ResponseStructure<String>> handlePrescrtionAlreadyExistException(PrescrtionAlreadyExistException exception){
		
		ResponseStructure<String> resp = new ResponseStructure<String>();
		resp.setStatusCode(HttpStatus.BAD_REQUEST.value());
		resp.setMessage(exception.getMessage());
		resp.setData("Failure!");
		
		return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
}

