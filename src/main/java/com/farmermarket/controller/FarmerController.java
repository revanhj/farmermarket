package com.farmermarket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/farmers")
@CrossOrigin(origins = "*")
public class FarmerController {

	
	/**
	 * Get Farmer By Id
	 */
	@GetMapping("/{farmerId}")
	public ResponseEntity<String> getFarmerById(@PathVariable Long farmerId) {

		String farmerResponse = "Farmer";
		return ResponseEntity.ok(farmerResponse);
	}

}