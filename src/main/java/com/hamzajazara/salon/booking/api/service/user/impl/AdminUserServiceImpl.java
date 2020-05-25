package com.hamzajazara.salon.booking.api.service.user.impl;

import com.hamzajazara.salon.booking.api.entity.user.AdminUserEntity;
import com.hamzajazara.salon.booking.api.repository.user.AdminUserRepository;
import com.hamzajazara.salon.booking.api.service.user.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Hamza Aljazara
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Override
    public Optional<AdminUserEntity> getAdminUser(long adminUserId) {
        return adminUserRepository.findById(adminUserId);
    }
}
