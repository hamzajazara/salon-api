package com.hamzajazara.salon.booking.api.service.lookup;

import com.hamzajazara.salon.booking.api.entity.lookup.CityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public interface CityService {

	/**
	 * 
	 * @param cityId
	 * @return
	 */
	CityEntity getCity(long cityId);

	/**
	 * 
	 * @param pageable
	 * @return
	 */
	Page<CityEntity> getCity(Pageable pageable);
}