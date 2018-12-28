package com.wuqaq.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.wuqaq.dto.User;
import com.wuqaq.exception.UserNotExistException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/me")
    public Object getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @DeleteMapping(value = "/{id:\\d+}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }


    @PutMapping(value = "/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {

        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(
                    error -> {
                        FieldError fieldError = (FieldError)error;
                        String message = fieldError.getField() + error.getDefaultMessage();
                        System.out.println(message);
                    }
            );
        }

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        return user;
    }


    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors) {

        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(
                    error -> System.out.println(error.getDefaultMessage())
            );
        }

        user.setId("1");
        return user;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query() {
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable String id) {

        System.out.println("调用getInfo服务");
        User user = new User();
        user.setUsername("tom");
        return user;
    }

}
