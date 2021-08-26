package com.ExcelWeb.service;

import com.ExcelWeb.dao.UsersDao;
import com.ExcelWeb.models.UserPrincipal;
import com.ExcelWeb.models.UserRoleEnum;
import com.ExcelWeb.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service(value = "1")
public class MyUserDetailsService implements UserDetailsService {

    //get user from the database, via Hibernate
    @Autowired
    private UsersDao userDao;

    @Override
    public UserDetails loadUserByUsername(final String username)throws UsernameNotFoundException {
//CUSTOM USER HERE vvv
        Users users = userDao.findByUserName(username);

        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(UserRoleEnum.ADMIN.name()));

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(users.getUsername(), users.getPassword(),roles);
//        return new UserPrincipal(users);
        return userDetails;

    }
    }