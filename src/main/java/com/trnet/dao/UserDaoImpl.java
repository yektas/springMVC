package com.trnet.dao;

import com.trnet.model.Kullanıcı;
import com.trnet.model.User;
import com.trnet.rowmapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    MongoTemplate mongoTemplate;

    public void mongoRegister(String name, String email, String password, Date registerDate) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRegisterDate(registerDate);
        mongoTemplate.save(user, "users");
    }

    public User mongoGetUser(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));

        User user = mongoTemplate.findOne(query, User.class);

        return user;
    }

    public List<User> mongoGetUsers(Date startDate, Date endDate) {
        Query query = new Query();
        query.addCriteria(Criteria.where("registerDate").gt(startDate).lt(endDate));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }

    public void register(String ad_soyad, String email, String sifre) {
        String sql = "INSERT INTO kullanici (ad_soyad, email, sifre) VALUES (?,?,?)";
        jdbcTemplate.update(sql, ad_soyad, email, sifre);
    }

    public List<Kullanıcı> getUsers() {
        String sql = "SELECT * FROM kullanici";
        List<Kullanıcı> users = jdbcTemplate.query(sql, new UserMapper());
        return users;
    }

    public Kullanıcı getUser(int id) {
        String sql = "SELECT * FROM kullanici WHERE id=" + id;
        Kullanıcı user = (Kullanıcı) jdbcTemplate.query(sql, new UserMapper()).get(0);
        return user;
    }

    public void changePassword(int id, String yeniSifre) {

        String sql = "UPDATE kullanici SET sifre = (?) WHERE id=" + id;
        jdbcTemplate.update(sql, yeniSifre);
    }

    public void deleteUser(int id) {
        String sql = "DELETE FROM kullanici WHERE id=" + id;
        jdbcTemplate.update(sql);
    }
}
