package com.gipotalamus.app.services;

import com.gipotalamus.app.entities.JokeUser;
import com.gipotalamus.app.repos.JokeUserR;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by gipotalamus on 03.12.16.
 */
@Service
public class JokeUserS {

    @Inject
    private JokeUserR jokeRepo;

    public JokeUser getByName(String name){
        return jokeRepo.findByName(name);
    }
}
