package com.hamzajazara.salon.booking.api.repository.user;

import com.hamzajazara.salon.booking.api.entity.user.AdminUserEntity;

import javax.transaction.Transactional;

/**
 * @author Hamza Aljazara
 */
@Transactional
public interface AdminUserRepository extends UserBaseRepository<AdminUserEntity> {
}
