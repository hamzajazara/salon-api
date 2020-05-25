package com.hamzajazara.salon.booking.api.repository.user;

import com.hamzajazara.salon.booking.api.entity.user.UserEntity;

import javax.transaction.Transactional;

/**
 *
 * @author Hamza Aljazara
 *
 */
@Transactional
public interface UserRepository extends UserBaseRepository<UserEntity> {
}