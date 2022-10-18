package com.example.restful.controller;

import com.example.restful.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {
    private List<User> users = new ArrayList<User>();

    @GetMapping("/users")
    public List<User> getUsers() {
         return users;
    }

    @PostMapping("/user")
    public User create(@RequestBody User user)
    {
        users.add(user);
        return user;
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == (id)) {
                return users.get(i);
            }
        }
        return null;
    }

    @PutMapping("/user")
    public void edit(@RequestBody User user)
    {
        for (int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getId() == user.getId())
            {
                users.set(i, user);
                break;
            }
        }
    }

    @DeleteMapping("/user")
    public void delete(@RequestParam(name = "id") int id)
    {
        for (int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getId() == id)
            {
                users.remove(i);
                break;
            }
        }
    }
}
