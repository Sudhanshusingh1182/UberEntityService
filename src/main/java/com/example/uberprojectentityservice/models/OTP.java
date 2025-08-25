package com.example.uberprojectentityservice.models;

import java.util.Random;

import jakarta.persistence.Entity;
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
public class OTP extends BaseModel{
		
	private String code;
	private String sentToNumber;
	
	public static OTP make(String phoneNumber) {
		
		Random random= new Random();
		
		Integer num = random.nextInt(9000)+ 1000;
		return OTP.builder()
				.sentToNumber(phoneNumber)
				.code(num.toString())
				.build();
	}
	
}
