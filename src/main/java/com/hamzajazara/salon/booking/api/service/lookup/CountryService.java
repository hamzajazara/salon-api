package com.hamzajazara.salon.booking.api.service.lookup;

import com.hamzajazara.salon.booking.api.entity.lookup.CountryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public interface CountryService {

	/**
	 * 
	 * @param countryId
	 * @return
	 */
	CountryEntity getCountry(long countryId);

	/**
	 * 
	 * @param pageable
	 * @return
	 */
	Page<CountryEntity> getCountry(Pageable pageable);
}