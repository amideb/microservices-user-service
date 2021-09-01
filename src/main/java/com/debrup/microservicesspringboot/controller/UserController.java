package com.debrup.microservicesspringboot.controller;

import com.debrup.microservicesspringboot.entity.User;
import com.debrup.microservicesspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId){

        User user = this.userService.getUser(userId);
       // http://localhost:9002/api/contact/user/1111
        List contacts = this.restTemplate.getForObject("http://contact-service/api/contact/user/"+ user.getUserId(), List.class);

        user.setContacts(contacts);

        return user;
    }

}
