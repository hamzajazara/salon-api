package com.hamzajazara.salon.booking.api.service;

import com.hamzajazara.salon.booking.api.entity.AddressEntity;
import com.hamzajazara.salon.booking.api.entity.user.SalonUserEntity;
import com.hamzajazara.salon.booking.api.model.Address;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public interface AddressService {

	/**
	 * 
	 * @param school
	 * @return
	 */
	AddressEntity save(AddressEntity school);

	/**
	 * 
	 * @param schoolRegistrationRequest
	 * @param adminUser
	 * @return
	 */
	AddressEntity create(Address address, SalonUserEntity adminUser);

	/**
	 * 
	 * @param schoolUpdateRequest
	 * @param address
	 * @return
	 */
	AddressEntity update(Address addressUpdateRequest, AddressEntity address);
}