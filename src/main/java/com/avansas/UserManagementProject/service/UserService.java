package com.avansas.UserManagementProject.service;

import com.avansas.UserManagementProject.dao.UserDao;
import com.avansas.UserManagementProject.exception.UserEntityNotFoundException;
import com.avansas.UserManagementProject.exception.UserEntityNotSavedException;
import com.avansas.UserManagementProject.exception.UserEntityNotUpdatedException;
import com.avansas.UserManagementProject.exception.UsernameNotFoundException;
import com.avansas.UserManagementProject.mapper.MapperForUser;
import com.avansas.UserManagementProject.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;
    private final MapperForUser mapperForUser;

    @Autowired
    public UserService(UserDao userDao, MapperForUser mapperForUser) {
        this.userDao = userDao;
        this.mapperForUser = mapperForUser;
    }

    public List<UserEntity> getAllUsers() {
        return userDao.selectAllUser().orElseThrow(UserEntityNotFoundException::new);
    }

    public UserEntity saveUser(UserEntity userEntity) {
        return userDao.saveUser(userEntity).orElseThrow(UserEntityNotSavedException::new);
    }

    public UserEntity getUserById(Long id) {
        return userDao.selectUserById(id).orElseThrow(UserEntityNotFoundException::new);
    }

    public UserEntity getUserByUsername(String username) {
        return userDao.selectUserByUsername(username).orElseThrow(UsernameNotFoundException::new);
    }

    public UserEntity updateUser(UserEntity userEntity) {
        Long userId = getUserByUsername(userEntity.getUsername()).getId(); // To control whether exist or it throws
        userEntity.setId(userId);
        deleteUserById(userEntity.getId());
        return userDao.updateUser(userEntity).orElseThrow(UserEntityNotUpdatedException::new);
    }

    public boolean deleteUserById(Long id) {
        return userDao.deleteUserById(id);
    }

}