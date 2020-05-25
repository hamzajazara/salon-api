package com.hamzajazara.salon.booking.api.controller;

import java.io.IOException;

import javax.validation.Valid;

import com.hamzajazara.salon.booking.api.entity.user.UserEntity;
import com.hamzajazara.salon.booking.api.model.constatnt.UserType;
import com.hamzajazara.salon.booking.api.model.request.user.UserRegistrationRequest;
import com.hamzajazara.salon.booking.api.model.response.user.UserInfoResponse;
import com.hamzajazara.salon.booking.api.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@RestController
@RequestMapping("/api/user")
@Api(tags = "User")
public class UserController {

	@Autowired
	private UserService<?> userService;

	@Autowired
	private ConsumerTokenServices consumerTokenServices;

	@GetMapping("/welcome")
	@ApiOperation(value = "Allow to the user to register")
	public ResponseEntity<String> welcome() {
		return new ResponseEntity<>("Welcome", HttpStatus.CREATED);
	}

	@PostMapping("/register")
	@ApiOperation(value = "Allow to the user to register")
	public ResponseEntity<UserInfoResponse> registerOwner(
			@Valid @RequestBody UserRegistrationRequest userRegistrationRequest) {
		return new ResponseEntity<>(
				new UserInfoResponse(userService.create(userRegistrationRequest, UserType.SALON_USER)),
				HttpStatus.CREATED);
	}

	@ApiOperation(value = "Revoke user token")
	@DeleteMapping("/logout")
	public ResponseEntity<HttpStatus> logout() throws IOException {
		OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) SecurityContextHolder.getContext()
				.getAuthentication().getDetails();
		consumerTokenServices.revokeToken(details.getTokenValue());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/who-am-i")
	@ApiOperation(value = "Who Am I")
	public ResponseEntity<UserInfoResponse> whoAmI(@AuthenticationPrincipal UserEntity user) {
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}

		return new ResponseEntity<>(new UserInfoResponse(user), HttpStatus.CREATED);
	}
}
