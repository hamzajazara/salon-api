package com.hamzajazara.salon.booking.api.service.impl;

import com.hamzajazara.salon.booking.api.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hamzajazara.salon.booking.api.entity.AddressEntity;
import com.hamzajazara.salon.booking.api.entity.user.SalonUserEntity;
import com.hamzajazara.salon.booking.api.model.Address;
import com.hamzajazara.salon.booking.api.repository.AddressRepository;
import com.hamzajazara.salon.booking.api.utils.Mapper;
import com.hamzajazara.salon.booking.api.utils.PointUtils;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public AddressEntity save(AddressEntity school) {
		return addressRepository.saveAndFlush(school);
	}

	@Override
	public AddressEntity create(Address address, SalonUserEntity adminUser) {
		AddressEntity addressEntity = Mapper.map(address, AddressEntity.class);
		addressEntity.setLocation(PointUtils.create(address.getPoint()));
		return save(addressEntity);
	}

	@Override
	public AddressEntity update(Address addressUpdateRequest, AddressEntity address) {
		address.setLocation(PointUtils.create(addressUpdateRequest.getPoint()));
		address.setLocationName(addressUpdateRequest.getLocationName());
		address.setEmail(addressUpdateRequest.getEmail());
		address.setPhoneNumber(addressUpdateRequest.getPhoneNumber());
		return save(address);
	}
}