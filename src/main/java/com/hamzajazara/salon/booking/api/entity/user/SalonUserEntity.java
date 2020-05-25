package com.hamzajazara.salon.booking.api.entity.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Entity(name = "SalonUser")
@Table(name = "salon_users")
@DiscriminatorValue("SALON_USER")
@Setter
@Getter
public class SalonUserEntity extends UserEntity {
	private static final long serialVersionUID = 1L;
}
