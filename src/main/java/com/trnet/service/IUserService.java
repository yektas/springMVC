package com.trnet.service;

import com.trnet.model.Kullanıcı;
import com.trnet.model.User;

import java.util.Date;
import java.util.List;

public interface IUserService {

    public Kullanıcı getUser(int id);

    public List<Kullanıcı> getUsers();

    public void register(String ad_soyad, String email, String sifre);

    public void changePassword(int id, String yeniSifre);

    public void deleteUser(int id);

    public void mongoRegisterUser(String name, String email, String password, Date registerDate);

    public User mongoGetUser(String name);

    public List<User> mongoGetUsers(Date startDate, Date endDate);

}
