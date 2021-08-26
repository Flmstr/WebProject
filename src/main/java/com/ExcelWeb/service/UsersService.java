package com.ExcelWeb.service;

import com.ExcelWeb.dao.UsersDao;
import com.ExcelWeb.models.Users;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsersService {
    @Autowired
    private UsersDao usersDao;

//    @Override
//    public UserDetails loadUserByUsername(final String login)
//            throws UsernameNotFoundException {
//
//        Users users = usersDao.findByUserName(login);
//
//
//        return users;
//
//    }

    public Users findUsersById(int id){
        return usersDao.findById(id);
    }

    public void saveUsersDao(Users typeWork){
        usersDao.save(typeWork);
    }

    public void deleteUsers(Users typeWork){
        usersDao.delete(typeWork);
    }

    public void updateUsers(Users typeWork){
        usersDao.update(typeWork);
    }

    public List<Users> findAllUsers(){
        return usersDao.findAll();
    }

}
