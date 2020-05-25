package com.hamzajazara.salon.booking.api.service.user.impl;

import com.hamzajazara.salon.booking.api.entity.user.RoleEntity;
import com.hamzajazara.salon.booking.api.entity.user.SalonUserEntity;
import com.hamzajazara.salon.booking.api.entity.user.UserEntity;
import com.hamzajazara.salon.booking.api.exception.NoSuchElementFoundException;
import com.hamzajazara.salon.booking.api.exception.NotAuthorizedException;
import com.hamzajazara.salon.booking.api.model.constatnt.UserType;
import com.hamzajazara.salon.booking.api.model.request.user.UserRegistrationRequest;
import com.hamzajazara.salon.booking.api.repository.user.UserBaseRepository;
import com.hamzajazara.salon.booking.api.repository.user.UserRepository;
import com.hamzajazara.salon.booking.api.service.user.RoleService;
import com.hamzajazara.salon.booking.api.service.user.UserService;
import com.hamzajazara.salon.booking.api.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author Hamza Aljazara
 */
@Service
public class UserServiceImpl<T extends UserEntity> implements UserService<UserEntity>, UserDetailsService {

    @Autowired
    private UserBaseRepository<UserEntity> userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).get();
    }

    @Override
    public boolean isUserExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userRepository.saveAndFlush(userEntity);
    }

    @Override
    public UserEntity getUser(long userId) {
        return userRepository.findById(userId).orElseThrow(NoSuchElementFoundException::new);
    }

    @Override
    public UserEntity create(UserRegistrationRequest userRegistrationRequest, UserType userType) {
        UserEntity createdUser = create(userRegistrationRequest, userType, null);
        return save(createdUser);
    }

    @Override
    public UserEntity create(UserRegistrationRequest userRegistrationRequest, UserType userType,
                             UserEntity createdUser) {
        if (isUserExist(userRegistrationRequest.getEmail())) {
            throw new RuntimeException();
        }

        UserEntity userEntity = userFactory(userRegistrationRequest, userType, createdUser);
        userEntity.setPassword(passwordEncoder.encode(userRegistrationRequest.getPassword()));
        userEntity.setEnabled(true);
        userEntity.setVerified(true);

        // user role
        RoleEntity roleEntity = roleService.getRole(userType.getValue());
        userEntity.setRoles(Collections.singletonList(roleEntity));

        return userEntity;
    }

    @Override
    public <R extends UserRegistrationRequest> UserEntity userFactory(R userRegistrationRequest,
                                                                      UserType userType,
                                                                      UserEntity createdUser) {
        UserEntity userEntity;
        switch (userType) {
            case SALON_USER:
                userEntity = Mapper.map(userRegistrationRequest, SalonUserEntity.class);
                userEntity.setUserType(UserType.SALON_USER);
                break;
            default:
                throw new NoSuchElementFoundException();
        }
        return userEntity;
    }
}