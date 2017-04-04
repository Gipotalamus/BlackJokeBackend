package com.gipotalamus.app.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gipotalamus.app.entities.JokeUser;
import com.gipotalamus.app.services.JokeUserS;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gipotalamus on 17.01.17.
 */
@RestController
@RequestMapping("/users")
public class UserC {

    @Inject
    JokeUserS jokeUserS;

    @RequestMapping("/")
    public List<String> getAll() {
        return Arrays.asList("Muroxa", "User");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public JokeUser add(@RequestPart("user") JokeUser user, @RequestPart("photo") MultipartFile photo, HttpServletRequest request) throws IOException {
        JokeUser savedUser = jokeUserS.add(user);
        String picPath = "/home/gipotalamus/Documents/upload/" + photo.getOriginalFilename();
        File file = new File(picPath);
        photo.transferTo(file);
        savedUser.setPhoto("http://localhost:8080/upload/" + photo.getOriginalFilename());
        return jokeUserS.add(savedUser);
    }
}
