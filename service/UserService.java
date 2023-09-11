package com.commerce.app.service;

import com.commerce.app.dao.RoleDao;
import com.commerce.app.dao.UserDao;
import com.commerce.app.entity.Role;
import com.commerce.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserDao userDao;


    public User registerNewUser(User user) {
return userDao.save(user);}

    public void initRolesAndUser(){
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("default role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserFistName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName("admin123");
        adminUser.setUserPassword("admin@123");
        Set<Role> adminRoles =new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        User user = new User();
        user.setUserFistName("tharaka");
        user.setUserLastName("tharaka");
        user.setUserName("tharaka123");
        user.setUserPassword("tharaka@123");
        Set<Role> userRoles =new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);
    }
}
