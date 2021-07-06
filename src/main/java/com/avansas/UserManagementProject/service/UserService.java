package com.avansas.UserManagementProject.service;

import com.avansas.UserManagementProject.dao.UserDao;
import com.avansas.UserManagementProject.exception.UserEntityNotFoundException;
import com.avansas.UserManagementProject.exception.UserEntityNotSavedException;
import com.avansas.UserManagementProject.exception.UserEntityNotUpdatedException;
import com.avansas.UserManagementProject.exception.UsernameNotFoundException;
import com.avansas.UserManagementProject.mapper.MapperForUser;
import com.avansas.UserManagementProject.model.User;
import com.avansas.UserManagementProject.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserDao userDao;
    private final MapperForUser mapperForUser;

    @Autowired
    public UserService(UserDao userDao, MapperForUser mapperForUser) {
        this.userDao = userDao;
        this.mapperForUser = mapperForUser;
    }

    public List<User> getAllUsers() {
        List<UserEntity> userEntities = userDao.selectAllUser()
                .orElseThrow(UserEntityNotFoundException::new);
        return userEntities
                .stream()
                .map(mapperForUser::convertToUser)
                .collect(Collectors.toList());
    }

    public User saveUser(User user) {
        Optional<UserEntity> userEntity = userDao.saveUser(mapperForUser.convertToUserEntity(user));
        return mapperForUser.convertToUser(userEntity
                .orElseThrow(UserEntityNotSavedException::new));
    }

    public User getUserById(Long id) {
        UserEntity userEntity = userDao.selectUserById(id)
                .orElseThrow(UserEntityNotFoundException::new);
        return mapperForUser.convertToUser(userEntity);
    }

    public User getUserByUsername(String username) {
        UserEntity userEntity = userDao.selectUserByUsername(username)
                .orElseThrow(UsernameNotFoundException::new);
        return mapperForUser.convertToUser(userEntity);
    }

    public User updateUser(UserEntity userEntity) {
        Long userId = getUserByUsername(userEntity.getUsername()).getId(); // To control whether exist or it throws
        userEntity.setId(userId);
        deleteUserById(userEntity.getId());
        UserEntity resultEntity = userDao.updateUser(userEntity).orElseThrow(UserEntityNotUpdatedException::new);
        return mapperForUser.convertToUser(resultEntity);
    }

    public boolean deleteUserById(Long id) {
        return userDao.deleteUserById(id);
    }

}