package com.hamzajazara.salon.booking.api.model.constatnt;

import lombok.Getter;

@Getter
public enum UserType {

	ADMIN(1), SALON_USER(2);

	long value;

	UserType(long value) {
		this.value = value;
	}
}
