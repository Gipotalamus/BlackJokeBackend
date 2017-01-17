package com.gipotalamus.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by gipotalamus on 17.01.17.
 */
@RestController
@RequestMapping("/users")
public class UserC {

    @RequestMapping("/")
    public List<String> getAll() {
        return Arrays.asList("Muroxa", "User");
    }
}
