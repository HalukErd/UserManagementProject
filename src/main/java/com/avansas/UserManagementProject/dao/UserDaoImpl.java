package com.avansas.UserManagementProject.dao;

import com.avansas.UserManagementProject.model.entity.UserEntity;
import com.avansas.UserManagementProject.dao.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {
    private final UserRepository userRepository;

    @Autowired
    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserEntity> selectUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<UserEntity> selectUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<List<UserEntity>> selectAllUser() {
        return Optional.of(userRepository.findAll());
    }

    @Override
    public Optional<UserEntity> saveUser(UserEntity userEntity) {
        return Optional.of(userRepository.save(userEntity));
    }

    @Override
    public Optional<UserEntity> updateUser(UserEntity userEntity) {
        return Optional.of(userRepository.save(userEntity));
    }

    @Override
    public boolean deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}