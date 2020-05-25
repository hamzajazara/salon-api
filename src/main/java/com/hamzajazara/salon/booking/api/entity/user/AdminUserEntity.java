package com.hamzajazara.salon.booking.api.entity.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Hamza Aljazara
 */
@Entity(name = "AdminUser")
@Table(name = "admin_users")
@DiscriminatorValue("ADMIN")
@Setter
@Getter
public class AdminUserEntity extends UserEntity {
	private static final long serialVersionUID = 1L;
}
