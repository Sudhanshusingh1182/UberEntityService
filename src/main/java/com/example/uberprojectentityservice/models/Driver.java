package com.example.uberprojectentityservice.models;

import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends BaseModel {
		
		private String name;
		
		@Column(nullable = false, unique = true)
		private String licenseNumber;
		
		private String phoneNumber;
		
		private String aadharCard;
		
		@OneToOne(mappedBy = "driver", cascade = CascadeType.ALL)
		private Car car;
		
		@Enumerated(value = EnumType.STRING)
		private DriverApprovalStatus driverApprovalStatus;
		
		@OneToOne
		private ExactLocation lastKnownLocation;
		
		@OneToOne
		private ExactLocation home;
		
		private String activeCity; 
		
		//update it every midnight instead of fetching it at runtime
		@DecimalMin(value="0.00",message="Rating must be greater than or equal to 0.00")
		@DecimalMax(value="5.00", message="Rating must be less than or equal to 5.00")
		private Double rating;
		
		private boolean isAvailable;
		
		//1:m , Driver: Booking
		@OneToMany(mappedBy = "driver",fetch = FetchType.LAZY)
		@Fetch(FetchMode.SUBSELECT)
		private List<Booking> bookings;
}
