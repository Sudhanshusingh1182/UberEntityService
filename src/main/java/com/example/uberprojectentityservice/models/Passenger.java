package com.example.uberprojectentityservice.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Passenger extends BaseModel {
      	
	    @Column(nullable = false)
		private String name;
		
		@Column(nullable = false)
		private String phoneNumber;
		
		@Column(nullable = false)
		private String email;
		
		@Column(nullable = false)
		private String password;
		
		@OneToMany(mappedBy = "passenger")
		private List<Booking> bookings= new ArrayList<>();
		
		@OneToOne
		private Booking activeBooking;
		
		@DecimalMin(value="0.00",message="Rating must be greater than or equal to 0.00")
		@DecimalMax(value="5.00", message="Rating must be less than or equal to 5.00")
	   private Double rating;
		
		@OneToOne
		private ExactLocation lastKnownLocation;
		
		@OneToOne
		private ExactLocation home;
}

