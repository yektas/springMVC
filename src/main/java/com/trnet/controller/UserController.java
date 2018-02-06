package com.trnet.controller;

import com.trnet.model.Kullanıcı;
import com.trnet.model.User;
import com.trnet.service.IUserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    IUserService userService;

    /*
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("ad_soyad") String ad_soyad,
                           @RequestParam("email") String email,
                           @RequestParam("sifre") String sifre, ModelMap mm) {
        userService.register(ad_soyad, email, sifre);
        mm.addAttribute("username", ad_soyad);
        return "kayitBasarili";

    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "registerPage";

    }
    */

    @RequestMapping(value = "/mongo-register", method = RequestMethod.POST)
    public String mongoRegister(@RequestParam("name") String name,
                                @RequestParam("email") String email,
                                @RequestParam("password") String password,
                                @RequestParam("registerDate") Date registerDate,
                                ModelMap mm) {
        userService.mongoRegisterUser(name, email, password, registerDate);
        return "kayitBasarili";

    }

    @RequestMapping(value = "/mongo-register", method = RequestMethod.GET)
    public String mongoRegister() {
        return "registerPage";
    }

    @RequestMapping(value = "/get-mongo-user/{name}", method = RequestMethod.GET)
    public String getMongoUser(ModelMap mm, @PathVariable("name") String name) {

        User user = userService.mongoGetUser(name);
        mm.addAttribute("user", user);
        return "users";
    }


    @RequestMapping(value = "/get-user/{id}")
    public String getUser(@PathVariable int id, ModelMap mm) {
        Kullanıcı kullanici = userService.getUser(id);
        mm.addAttribute("userData", kullanici);
        return "get-user";
    }

    @RequestMapping(value = "/get-users")
    public String getUsers(ModelMap mm) {
        List<Kullanıcı> users = userService.getUsers();
        mm.addAttribute("users", users);
        return "index";
    }

    @RequestMapping(value = "/delete-user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "delete complete";
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void changePassword(@RequestBody String jsonBody) {
        JSONObject jsonObject = new JSONObject(jsonBody);
        JSONObject data = jsonObject.getJSONObject("credentials");
        int id = data.getInt("id");
        String yeniSifre = data.getString("sifre");
        userService.changePassword(id, yeniSifre);
    }

    @RequestMapping(value = "/test-post", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String testing(@RequestBody String jsonBody) {
        JSONObject jsonObject = new JSONObject(jsonBody);
        String myDate = jsonObject.getString("date");
        String myTime = jsonObject.getString("time");
        System.out.println(myDate + " " + myTime);

        return jsonObject.toString();
    }


    @RequestMapping(value = "/test-post", method = RequestMethod.GET)
    public String testing() {
        return "pickTheDate";
    }
}
