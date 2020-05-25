package com.hamzajazara.salon.booking.api.service.user;

import com.hamzajazara.salon.booking.api.entity.user.RoleEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public interface RoleService {

	/**
	 * 
	 * @param roleId
	 * @return
	 */
	RoleEntity getRole(long roleId);
}