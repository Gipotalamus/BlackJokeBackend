package com.gipotalamus.app.services;

import com.gipotalamus.app.entities.JokeGroup;
import com.gipotalamus.app.repos.JokeGroupR;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gipotalamus on 28.11.16.
 */
@Service
public class JokeGroupS {
    @Inject
    private JokeGroupR groupRepo;

    public JokeGroup addOrUpdate(JokeGroup group) {
        return groupRepo.save(group);
    }

    public void remove(Long id) {
        groupRepo.delete(id);
    }

    public List<JokeGroup> getAll() {
        return groupRepo.findAll();
    }

    public JokeGroup get(Long id) {
        return groupRepo.findOne(id);
    }

    public JokeGroup getByName(String name) {
        return groupRepo.findOneByName(name);
    }
}
