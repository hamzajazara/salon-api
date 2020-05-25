package com.hamzajazara.salon.booking.api.service.lookup;

import com.hamzajazara.salon.booking.api.entity.lookup.LanguageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public interface LanguageService {

	/**
	 * 
	 * @param languageId
	 * @return
	 */
	LanguageEntity getLanguage(long languageId);

	/**
	 * 
	 * @param pageable
	 * @return
	 */
	Page<LanguageEntity> getLanguage(Pageable pageable);
}