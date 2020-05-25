package com.hamzajazara.salon.booking.api.model.response.lookup;

import com.hamzajazara.salon.booking.api.entity.lookup.CountryEntity;
import com.hamzajazara.salon.booking.api.utils.Mapper;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CountryResponse {

	private Long id;
	private String label;

	/**
	 * 
	 * @param countryEntity
	 */
	public CountryResponse(CountryEntity countryEntity) {
		Mapper.map(countryEntity, this);
	}
}
