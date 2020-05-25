package com.hamzajazara.salon.booking.api.repository;

import com.hamzajazara.salon.booking.api.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}