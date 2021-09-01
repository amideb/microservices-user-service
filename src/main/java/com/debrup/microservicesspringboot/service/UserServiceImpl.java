package com.debrup.microservicesspringboot.service;

import com.debrup.microservicesspringboot.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService{

    //fake user list

    List<User> list = List.of(
            new User(1111L, "Anushka Sharma", "7635412678"),
            new User(1112L, "Tom Harris", "7658934567"),
            new User(1113L, "Mohini Johnson", "675645367")

    );
    @Override
    public User getUser(Long id) {
        return this.list.stream().filter(user-> user.getUserId().equals(id)).findAny().orElse(null);
    }
}
