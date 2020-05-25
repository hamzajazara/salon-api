package com.hamzajazara.salon.booking.api.repository.user;

import javax.transaction.Transactional;

import com.hamzajazara.salon.booking.api.entity.user.SalonUserEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Transactional
public interface SalonUserRepository extends UserBaseRepository<SalonUserEntity> {
}
