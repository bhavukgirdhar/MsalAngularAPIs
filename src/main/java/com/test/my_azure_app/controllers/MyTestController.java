package com.test.my_azure_app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.my_azure_app.constants.ApiResponse;

@RestController
@RequestMapping("/api")
public class MyTestController {

	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<ApiResponse> test() {
		
		ApiResponse response = new ApiResponse();
		response.setResult("OK");
		
		return new ResponseEntity<String>(HttpStatus.OK).ok(response);
	}
}
