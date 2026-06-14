package com.farmermarket.controller;

import org.springframework.http.ResponseEntity;

import com.farmermarket.api.DefaultApi;
import com.farmermarket.dto.FarmerResponse;
import com.farmermarket.dto.LoginRequest;
import com.farmermarket.dto.LoginResponse;
import com.farmermarket.dto.RegisterFarmerRequest;

import jakarta.validation.Valid;

public class Farmer implements DefaultApi{


	@Override
	public ResponseEntity<LoginResponse> login(@Valid LoginRequest loginRequest) {
		// TODO Auto-generated method stub
		return DefaultApi.super.login(loginRequest);
	}

	@Override
	public ResponseEntity<FarmerResponse> registerFarmer(@Valid RegisterFarmerRequest registerFarmerRequest) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
