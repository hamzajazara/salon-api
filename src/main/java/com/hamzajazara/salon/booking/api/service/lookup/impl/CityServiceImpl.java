package com.hamzajazara.salon.booking.api.service.lookup.impl;

import com.hamzajazara.salon.booking.api.entity.lookup.CityEntity;
import com.hamzajazara.salon.booking.api.repository.lookup.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hamzajazara.salon.booking.api.exception.NoSuchElementFoundException;
import com.hamzajazara.salon.booking.api.service.lookup.CityService;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;

	/*
	 * @see com.nurseryapi.service.lookup.CityService#getCity(long)
	 */
	@Override
	public CityEntity getCity(long cityId) {
		return cityRepository.findById(cityId).orElseThrow(NoSuchElementFoundException::new);
	}

	/*
	 * @see
	 * com.nurseryapi.service.lookup.CityService#getCity(org.springframework.data.
	 * domain.Pageable)
	 */
	@Override
	public Page<CityEntity> getCity(Pageable pageable) {
		return cityRepository.findAll(pageable);
	}
}