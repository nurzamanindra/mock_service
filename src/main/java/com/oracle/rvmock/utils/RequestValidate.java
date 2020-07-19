package com.oracle.rvmock.utils;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.oracle.rvmock.exceptions.InvalidHeader;

@Component
public class RequestValidate {
	@Value("${header.api.key.name}")
	private String headerApiKeyName;
	
	@Value("${header.api.key}")
	private String headerApiKey;
	
	@Value("${header.x.signature.name}")
	private String headerXSignatureName;
	
	@Value("${header.x.signature}")
	private String headerXSignature;
	
	public boolean ValidatePathValirable(String var) {
		
		if(var.equalsIgnoreCase("")) {
			return false;
		}
		return true;
	}
	
	public boolean ValidateHeader(Map<String,String> headers) throws InvalidHeader{
		
		if (headers.get(headerApiKeyName) == null) {
			throw new InvalidHeader("No header name "+ headerApiKeyName);
		}
		if (headers.get(headerXSignatureName) == null) {
			throw new InvalidHeader("No header name "+ headerXSignatureName);
		}
		

//		if(headers.get(headerApiKeyName).equals("") ||
//				!headers.get(headerApiKeyName).equals(headerApiKey)) {
//			throw new InvalidHeader("wrong header value, header name: "+ headerApiKeyName);
//		}
//		if(headers.get(headerXSignatureName).equals("") ||
//				!headers.get(headerXSignatureName).equals(headerXSignature)) {
//			throw new InvalidHeader("wrong header value, header name: "+ headerXSignatureName);
//			
//		}
		return true;
	}
	
}
