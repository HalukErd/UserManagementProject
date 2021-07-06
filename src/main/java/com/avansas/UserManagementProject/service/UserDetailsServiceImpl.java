package com.avansas.UserManagementProject.service;

import com.avansas.UserManagementProject.dao.UserDao;
import com.avansas.UserManagementProject.mapper.MapperForUser;
import com.avansas.UserManagementProject.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("UserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDao userDao;
    private final MapperForUser mapperForUser;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao, MapperForUser mapperForUser) {
        this.userDao = userDao;
        this.mapperForUser = mapperForUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity applicationUserEntity = userDao.selectUserByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException(String.format("Username %s not found", username)));

        return mapperForUser.convertToUserDetails(applicationUserEntity);
    }
}