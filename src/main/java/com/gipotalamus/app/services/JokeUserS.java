package com.gipotalamus.app.services;

import com.gipotalamus.app.entities.JokeUser;
import com.gipotalamus.app.entities.Roles;
import com.gipotalamus.app.repos.JokeUserR;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gipotalamus on 03.12.16.
 */
@Service
public class JokeUserS implements UserDetailsService {

    @Inject
    private JokeUserR jokeUserRepo;

    public JokeUser getByName(String name){
        return jokeUserRepo.findByName(name);
    }

    public JokeUser add(JokeUser user) {
        return jokeUserRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        JokeUser user = jokeUserRepo.findByName(s);
        System.out.println(user);
        return new User(user.getName(), user.getPassword(), getAuthorities(user.getRole()));
    }

    public List<GrantedAuthority> getAuthorities(Roles role) {
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(role.toString()));
        return list;
    }
}
