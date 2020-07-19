package com.oracle.rvmock.service;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.oracle.rvmock.payload.Payload;

@Service
public class RvMockResponse {
	
	public Payload CreateResponse() {
		Payload p = new Payload();
		p.setTransaction_id("A008191010175306388817960")
			.setChannel("k6")
				.setStatus_code("00000")
					.setStatus_desc("Success");
		return p;
	}
	
	public HttpHeaders getHeaders(Map<String, String> headers) {
		HttpHeaders headersConsumer = new HttpHeaders();
		headersConsumer.setAll(headers);
		return headersConsumer;
	}

}
