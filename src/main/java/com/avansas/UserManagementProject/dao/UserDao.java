package com.avansas.UserManagementProject.dao;

import com.avansas.UserManagementProject.model.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<UserEntity> selectUserById(Long id);

    Optional<UserEntity> selectUserByUsername(String username);

    Optional<List<UserEntity>> selectAllUser();

    Optional<UserEntity> saveUser(UserEntity userEntity);

    Optional<UserEntity> updateUser(UserEntity userEntity);

    boolean deleteUserById(Long id);

}
