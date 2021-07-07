package com.avansas.UserManagementProject.mapper;


import com.avansas.UserManagementProject.controller.model.UserRequest;
import com.avansas.UserManagementProject.controller.model.UserResponse;
import com.avansas.UserManagementProject.model.Address;
import com.avansas.UserManagementProject.model.User;
import com.avansas.UserManagementProject.model.UserDetailsImpl;
import com.avansas.UserManagementProject.model.UserInformation;
import com.avansas.UserManagementProject.model.entity.AddressEntity;
import com.avansas.UserManagementProject.model.entity.UserEntity;
import com.avansas.UserManagementProject.model.entity.UserInformationEntity;
import com.avansas.UserManagementProject.model.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static com.avansas.UserManagementProject.model.enums.UserRole.REGULAR_USER;

@Component
public class MapperForUser {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MapperForUser(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse convertToUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getUserRole(),
                user.getUserInformation().getName(),
                user.getUserInformation().getLastName(),
                user.getUserInformation().getEmail(),
                user.getUserInformation().getPhoneNumber(),
                user.getUserInformation().getBirthDay(),
                user.getUserInformation().getAddress().getCity(),
                user.getUserInformation().getAddress().getTown()
        );
    }

    public UserEntity convertToUserEntity(UserRequest userRequest) {
        return new UserEntity(
                userRequest.getUsername(),
                passwordEncoder.encode(userRequest.getPassword()),
                REGULAR_USER,
                new UserInformationEntity(
                        userRequest.getName(),
                        userRequest.getLastName(),
                        userRequest.getEmail(),
                        userRequest.getPhoneNumber(),
                        userRequest.getBirthDay(),
                        new AddressEntity(
                                userRequest.getCity(),
                                userRequest.getTown()
                        )
                )
        );
    }
    
    public UserEntity convertToUserEntity(User user) {
        return new UserEntity(
                user.getUsername(),
                passwordEncoder.encode(user.getPassword()),
                REGULAR_USER,
                new UserInformationEntity(
                        user.getUserInformation().getName(),
                        user.getUserInformation().getLastName(),
                        user.getUserInformation().getEmail(),
                        user.getUserInformation().getPhoneNumber(),
                        user.getUserInformation().getBirthDay(),
                        new AddressEntity(
                                user.getUserInformation().getAddress().getCity(),
                                user.getUserInformation().getAddress().getTown()
                        )
                )
        );
    }

    public User convertToUser(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getUsername(),
                passwordEncoder.encode(userEntity.getPassword()),
                REGULAR_USER,
                new UserInformation(
                        userEntity.getUserInformationEntity().getName(),
                        userEntity.getUserInformationEntity().getLastName(),
                        userEntity.getUserInformationEntity().getEmail(),
                        userEntity.getUserInformationEntity().getPhoneNumber(),
                        userEntity.getUserInformationEntity().getBirthDay(),
                        new Address(
                                userEntity.getUserInformationEntity().getAddressEntity().getCity(),
                                userEntity.getUserInformationEntity().getAddressEntity().getTown()
                        )
                )
        );
    }

    public User convertToUser(UserRequest userRequest) {
        return new User(
                userRequest.getUsername(),
                passwordEncoder.encode(userRequest.getPassword()),
                REGULAR_USER,
                new UserInformation(
                        userRequest.getName(),
                        userRequest.getLastName(),
                        userRequest.getEmail(),
                        userRequest.getPhoneNumber(),
                        userRequest.getBirthDay(),
                        new Address(
                                userRequest.getCity(),
                                userRequest.getTown()
                        )
                )
        );
    }

    public UserDetails convertToUserDetails(UserEntity applicationUserEntity) {
        return new UserDetailsImpl(
                applicationUserEntity.getUsername(),
                applicationUserEntity.getPassword(),
                applicationUserEntity.getUserRole().getGrantedAuthorities()
        );
    }

    private UserInformationEntity convertToUserInformationEntity(UserInformation userInformation) {
        return new UserInformationEntity(
                userInformation.getName(),
                userInformation.getLastName(),
                userInformation.getEmail(),
                userInformation.getPhoneNumber(),
                userInformation.getBirthDay(),
                new AddressEntity(
                        userInformation.getAddress().getCity(),
                        userInformation.getAddress().getTown()
                )
        );
    }

    private UserInformation convertToUserInformation(UserInformationEntity userInformationEntity) {
        return new UserInformation(
                userInformationEntity.getName(),
                userInformationEntity.getLastName(),
                userInformationEntity.getEmail(),
                userInformationEntity.getPhoneNumber(),
                userInformationEntity.getBirthDay(),
                new Address(
                        userInformationEntity.getAddressEntity().getCity(),
                        userInformationEntity.getAddressEntity().getTown()
                )
        );
    }
}