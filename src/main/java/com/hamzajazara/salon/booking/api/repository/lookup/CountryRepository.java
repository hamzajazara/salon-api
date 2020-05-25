package com.hamzajazara.salon.booking.api.repository.lookup;

import com.hamzajazara.salon.booking.api.entity.lookup.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
}