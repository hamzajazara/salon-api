package com.hamzajazara.salon.booking.api.service.user;

import com.hamzajazara.salon.booking.api.entity.user.AdminUserEntity;

import java.util.Optional;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public interface AdminUserService {

	Optional<AdminUserEntity> getAdminUser(long adminUserId);
}