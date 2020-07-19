package com.oracle.rvmock.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.rvmock.payload.Payload;
import com.oracle.rvmock.service.RvMockResponse;
import com.oracle.rvmock.utils.RequestValidate;

@RestController
public class RvMockController {
	
	@Autowired
	private RequestValidate validate;
	
	@Autowired
	private RvMockResponse rvResponse;
	
	@GetMapping(path = "/payment/finnet/transactions/{invoice}")
	public ResponseEntity<Payload> getRvMockResponse(
			@PathVariable(name = "invoice") String invoice,
			@RequestParam Map<String,String> reqParam,
			@RequestHeader Map<String, String> headers) throws Exception {
		
		Payload p = rvResponse.CreateResponse();

		if(!validate.ValidateHeader(headers)) {
			p.setStatus_code("309999").setStatus_desc("invalid Header");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(rvResponse.getHeaders(headers)).body(p);
		}
		
		if(reqParam.containsKey("transaction_id")) {
			p.setTransaction_id(reqParam.get("transaction_id"));
		}
		if(reqParam.containsKey("channel")) {
			p.setChannel(reqParam.get("channel"));
		}
		
		return ResponseEntity.status(HttpStatus.OK).headers(rvResponse.getHeaders(headers)).body(p);
	}

}
