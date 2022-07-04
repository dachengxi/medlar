package me.cxis.http2.controller;

import me.cxis.http2.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getById")
    public User getById(@RequestParam Long id) {
        User user = new User();
        user.setId(id);
        user.setName("xiao hong");
        user.setAge(20);
        return user;
    }

    @PostMapping("/create")
    public Boolean create(@RequestBody User user) {
        return true;
    }
}
