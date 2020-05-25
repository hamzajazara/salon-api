package com.hamzajazara.salon.booking.api.service.lookup.impl;

import com.hamzajazara.salon.booking.api.entity.lookup.LanguageEntity;
import com.hamzajazara.salon.booking.api.exception.NoSuchElementFoundException;
import com.hamzajazara.salon.booking.api.repository.lookup.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hamzajazara.salon.booking.api.service.lookup.LanguageService;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepository languageRepository;

	/*
	 * @see com.nurseryapi.service.lookup.LanguageService#getLanguage(long)
	 */
	@Override
	public LanguageEntity getLanguage(long languageId) {
		return languageRepository.findById(languageId).orElseThrow(NoSuchElementFoundException::new);
	}

	/*
	 * @see
	 * com.nurseryapi.service.lookup.LanguageService#getLanguage(org.springframework
	 * .data.domain.Pageable)
	 */
	@Override
	public Page<LanguageEntity> getLanguage(Pageable pageable) {
		return languageRepository.findAll(pageable);
	}
}