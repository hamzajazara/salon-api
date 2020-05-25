package com.hamzajazara.salon.booking.api.repository.user;

import java.util.Optional;

import com.hamzajazara.salon.booking.api.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@NoRepositoryBean
public interface UserBaseRepository<T extends UserEntity> extends JpaRepository<T, Long> {
	
	Optional<T> findByUsername(String email);

	Optional<T> findByEmail(String email);
}
