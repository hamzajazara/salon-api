package com.hamzajazara.salon.booking.api.model.response.lookup;

import com.hamzajazara.salon.booking.api.entity.lookup.LanguageEntity;
import com.hamzajazara.salon.booking.api.utils.Mapper;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LanguageResponse {

	private Long id;
	private String label;

	/**
	 * 
	 * @param languageEntity
	 */
	public LanguageResponse(LanguageEntity languageEntity) {
		Mapper.map(languageEntity, this);
	}
}
