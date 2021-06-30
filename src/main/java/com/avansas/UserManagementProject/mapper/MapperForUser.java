package com.avansas.UserManagementProject.mapper;


import com.avansas.UserManagementProject.controller.model.UserRequest;
import com.avansas.UserManagementProject.controller.model.UserResponse;
import com.avansas.UserManagementProject.model.UserDetailsImpl;
import com.avansas.UserManagementProject.model.UserInformation;
import com.avansas.UserManagementProject.model.entity.UserEntity;
import com.avansas.UserManagementProject.model.entity.UserInformationEntity;
import com.avansas.UserManagementProject.model.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MapperForUser {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MapperForUser(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse convertToUserResponse(UserEntity userEntity) {
        return new UserResponse(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getUserRole(),
                convertToUserInformation(userEntity.getUserInformationEntity())
        );
    }

    public UserEntity convertToUserEntity(UserRequest userRequest) {
        return new UserEntity(
                userRequest.getUsername(),
                passwordEncoder.encode(userRequest.getPassword()),
                UserRole.REGULAR_USER,
                convertToUserInformationEntity(userRequest.getUserInformation())
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
                userInformation.getBirthDay()
        );
    }

    private UserInformation convertToUserInformation(UserInformationEntity userInformationEntity) {
        return new UserInformation(
                userInformationEntity.getName(),
                userInformationEntity.getLastName(),
                userInformationEntity.getEmail(),
                userInformationEntity.getPhoneNumber(),
                userInformationEntity.getBirthDay()
        );
    }
}