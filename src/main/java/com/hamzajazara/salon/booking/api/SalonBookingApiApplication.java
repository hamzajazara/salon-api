package com.hamzajazara.salon.booking.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:config/${spring.profile.actives:dev}/application.properties")
public class SalonBookingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalonBookingApiApplication.class, args);
	}

}
