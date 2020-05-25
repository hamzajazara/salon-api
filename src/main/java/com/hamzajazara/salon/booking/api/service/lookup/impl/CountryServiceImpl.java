package com.hamzajazara.salon.booking.api.service.lookup.impl;

import com.hamzajazara.salon.booking.api.entity.lookup.CountryEntity;
import com.hamzajazara.salon.booking.api.exception.NoSuchElementFoundException;
import com.hamzajazara.salon.booking.api.repository.lookup.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hamzajazara.salon.booking.api.service.lookup.CountryService;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	/*
	 * @see com.nurseryapi.service.lookup.CountryService#getCountry(long)
	 */
	@Override
	public CountryEntity getCountry(long countryId) {
		return countryRepository.findById(countryId).orElseThrow(NoSuchElementFoundException::new);
	}

	/*
	 * @see
	 * com.nurseryapi.service.lookup.CountryService#getCountry(org.springframework.
	 * data.domain.Pageable)
	 */
	@Override
	public Page<CountryEntity> getCountry(Pageable pageable) {
		return countryRepository.findAll(pageable);
	}
}