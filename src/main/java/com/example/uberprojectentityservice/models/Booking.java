package com.example.uberprojectentityservice.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
//@Table(indexes = {
//		@Index(columnList = "driver_id")
//})
public class Booking extends BaseModel {
	
	@Enumerated(value = EnumType.STRING)
	private BookingStatus bookingStatus;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	 private Date startTime;
	 
	@Temporal(value=TemporalType.TIMESTAMP)
	 private Date endTime;
	 
	 private Long totalDistance;
	 
	 @ManyToOne(fetch= FetchType.LAZY)
	 private Driver driver;
	 
	 @ManyToOne(fetch= FetchType.LAZY)
	 private Passenger passenger;
	 
	 @OneToOne
	 private ExactLocation startLocation;
	 
	 @OneToOne
	 private ExactLocation endLocation;
}