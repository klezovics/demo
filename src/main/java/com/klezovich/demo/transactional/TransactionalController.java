package com.klezovich.demo.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionalController {

    @Autowired
    UserUpdateService service;

    @GetMapping("/update-users")
    public Iterable<User> updateUsers() {

        return service.updateUsers();
    }

}
