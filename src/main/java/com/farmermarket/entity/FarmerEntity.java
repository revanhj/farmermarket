package com.farmermarket.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "farmers", uniqueConstraints = {
		@UniqueConstraint(name = "uk_farmer_mobile", columnNames = "mobile_number") })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FarmerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "farmer_id")
	private Long farmerId;

	@Column(name = "farmer_name", nullable = false, length = 100)
	private String farmerName;

	@Column(name = "mobile_number", nullable = false, unique = true, length = 15)
	private String mobileNumber;

	@Column(name = "email", length = 100)
	private String email;

	@Column(name = "village", length = 100)
	private String village;

	@Column(name = "district", length = 100)
	private String district;

	@Column(name = "state", length = 100)
	private String state;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "active", nullable = false)
	private Boolean active;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

	@PrePersist
	public void prePersist() {

		LocalDateTime now = LocalDateTime.now();

		this.createdDate = now;
		this.updatedDate = now;

		if (this.active == null) {
			this.active = true;
		}
	}

	@PreUpdate
	public void preUpdate() {

		this.updatedDate = LocalDateTime.now();
	}
}