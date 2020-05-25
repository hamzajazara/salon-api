package com.hamzajazara.salon.booking.api.model.response.user;

import java.util.ArrayList;
import java.util.List;

import com.hamzajazara.salon.booking.api.entity.user.UserEntity;
import com.hamzajazara.salon.booking.api.model.constatnt.UserType;
import com.hamzajazara.salon.booking.api.utils.Mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {

	private String firstName;

	private String lastName;

	private String email;

	private String phoneNumber;

	private UserType userType;

	private boolean verified;

	private List<String> roles;

	/**
	 * 
	 * @param user
	 */
	public UserInfoResponse(UserEntity user) {
		Mapper.map(user, this);
		roles = new ArrayList<>();
		user.getRoles().forEach(role -> roles.add(role.getName()));
	}
}
