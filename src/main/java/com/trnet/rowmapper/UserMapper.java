package com.trnet.rowmapper;

import com.trnet.model.Kullanıcı;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {

    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Kullanıcı user = new Kullanıcı();
        user.setKullanici_id(resultSet.getInt("id"));
        user.setAd_soyad(resultSet.getString("ad_soyad"));
        user.setEmail(resultSet.getString("email"));
        user.setSifre(resultSet.getString("sifre"));
        return user;
    }
}
