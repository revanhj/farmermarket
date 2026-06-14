package com.farmermarket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmermarket.entity.FarmerEntity;

@Repository
public interface FarmerRepository extends JpaRepository<FarmerEntity, Long> {

	Optional<FarmerEntity> findByMobileNumber(String mobileNumber);

	boolean existsByMobileNumber(String mobileNumber);
}