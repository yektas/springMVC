package com.trnet.service;

import com.trnet.dao.IUserDao;
import com.trnet.model.Kullanıcı;
import com.trnet.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao userDao;

    public Kullanıcı getUser(int id) {
        return userDao.getUser(id);
    }

    public List<Kullanıcı> getUsers() {
        return userDao.getUsers();
    }

    public void register(String ad_soyad, String email, String sifre) {
        userDao.register(ad_soyad, email, sifre);
    }

    public void changePassword(int id, String yeniSifre) {
        userDao.changePassword(id, yeniSifre);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    public void mongoRegisterUser(String name, String email, String password, Date registerDate) {
        userDao.mongoRegister(name, email, password, registerDate);
    }

    public User mongoGetUser(String name) {
        return userDao.mongoGetUser(name);
    }

    public List<User> mongoGetUsers(Date startDate, Date endDate) {
        return userDao.mongoGetUsers(startDate, endDate);
    }
}
