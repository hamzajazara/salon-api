package com.hamzajazara.salon.booking.api.repository.user;

import com.hamzajazara.salon.booking.api.entity.user.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Hamza Aljazara
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
