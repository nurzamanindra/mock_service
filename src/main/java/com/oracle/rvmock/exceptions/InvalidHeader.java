package com.oracle.rvmock.exceptions;

import com.oracle.rvmock.payload.Payload;

import lombok.Getter;

@Getter
public class InvalidHeader extends RuntimeException{
	Payload payload;

	public InvalidHeader(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidHeader(String message) {
		super(message);
	}

	public InvalidHeader(Throwable cause) {
		super(cause);
	}
	
	public InvalidHeader(Payload req, String message) {
		super(message);
		this.payload = req;
	}
}
