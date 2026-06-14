package com.farmermarket.service;

import com.farmermarket.dto.FarmerResponse;
import com.farmermarket.dto.LoginRequest;
import com.farmermarket.dto.LoginResponse;
import com.farmermarket.dto.RegisterFarmerRequest;

public interface FarmerService {

	FarmerResponse registerFarmer(RegisterFarmerRequest request);
	LoginResponse login(LoginRequest request);
}
