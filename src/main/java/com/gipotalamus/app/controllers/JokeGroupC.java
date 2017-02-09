package com.gipotalamus.app.controllers;

import com.gipotalamus.app.entities.JokeGroup;
import com.gipotalamus.app.services.JokeGroupS;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gipotalamus on 28.11.16.
 */
@RestController
@RequestMapping(value = "/groups")
@CrossOrigin
public class JokeGroupC {
    @Inject
    private JokeGroupS groupS;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<JokeGroup> getAll() {
        return groupS.getAll();
    }

    @RequestMapping(value = "/{groupId}", method = RequestMethod.GET)
    public JokeGroup get(@PathVariable("groupId") Long id) {
        return groupS.get(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public JokeGroup add(@RequestBody JokeGroup group) {
        return groupS.addOrUpdate(group);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public JokeGroup update(@RequestBody JokeGroup group) {
        return groupS.addOrUpdate(group);
    }

    @RequestMapping(value = "/{groupId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable("groupId") Long id) {
        groupS.remove(id);
    }
}
