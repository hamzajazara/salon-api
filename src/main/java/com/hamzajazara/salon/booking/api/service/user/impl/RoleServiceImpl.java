package com.hamzajazara.salon.booking.api.service.user.impl;

import com.hamzajazara.salon.booking.api.entity.user.RoleEntity;
import com.hamzajazara.salon.booking.api.repository.user.RoleRepository;
import com.hamzajazara.salon.booking.api.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public RoleEntity getRole(long roleId) {
		return roleRepository.findById(roleId).get();
	}
}