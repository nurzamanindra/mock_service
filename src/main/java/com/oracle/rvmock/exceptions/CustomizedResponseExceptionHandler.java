package com.oracle.rvmock.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.oracle.rvmock.payload.Payload;

@ControllerAdvice
public class CustomizedResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@SuppressWarnings("unchecked")
	@ExceptionHandler
	public ResponseEntity<Payload> CustomeExceptions(InvalidHeader e) {
		Payload p = null;
		if(e.getPayload() != null) {
			p = e.getPayload();
		}else {
			p = new Payload();
		}
		p.setTransaction_id("A008191010175306388817960")
			.setChannel("k4")
				.setStatus_code("309999")
					.setStatus_desc(e.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(p);

	}

	@ExceptionHandler
	public ResponseEntity<Payload> CustomeExceptions(Exception e) {
		Payload response = new Payload();
		response.setTransaction_id("A008191010175306388817960")
				.setChannel("k4")
					.setStatus_code("309999")
						.setStatus_desc(e.getMessage());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}