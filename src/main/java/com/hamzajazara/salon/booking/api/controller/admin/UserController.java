package com.hamzajazara.salon.booking.api.controller.admin;

import com.hamzajazara.salon.booking.api.entity.user.AdminUserEntity;
import com.hamzajazara.salon.booking.api.model.constatnt.UserType;
import com.hamzajazara.salon.booking.api.model.request.user.UserRegistrationRequest;
import com.hamzajazara.salon.booking.api.model.response.user.UserInfoResponse;
import com.hamzajazara.salon.booking.api.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Hamza Aljazara
 */
@RestController("AdminUserController")
@RequestMapping("/api/admin/user")
@Api(tags = "Admin/User")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class UserController {

    @Autowired
    private UserService<AdminUserEntity> userService;

    @PostMapping("/register")
    @ApiOperation(value = "Allow to the admin to register owner user")
    public ResponseEntity<UserInfoResponse> registerOwner(
            @Valid @RequestBody UserRegistrationRequest userRegistrationRequest,
            @AuthenticationPrincipal AdminUserEntity adminUser) {
        return new ResponseEntity<>(
                new UserInfoResponse(userService.create(userRegistrationRequest, UserType.ADMIN, adminUser)),
                HttpStatus.CREATED);
    }
}
