package com.trnet.dao;

import com.trnet.model.Kullanıcı;
import com.trnet.model.User;

import java.util.Date;
import java.util.List;

public interface IUserDao {

    public void register(String ad_soyad, String email, String sifre);

    public List<Kullanıcı> getUsers();

    public Kullanıcı getUser(int id);

    public void changePassword(int id, String yeniSifre);

    public void deleteUser(int id);

    public void mongoRegister(String name, String email, String password, Date registerDate);

    public User mongoGetUser(String name);

    public List<User> mongoGetUsers(Date startDate, Date endDate);
}
