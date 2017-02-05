package com.gipotalamus.app.controllers;

import com.gipotalamus.app.entities.Joke;
import com.gipotalamus.app.services.JokeS;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gipotalamus on 28.11.16.
 */
@RestController
@RequestMapping(value = "/jokes")
@CrossOrigin
public class JokeC {
    @Inject
    private JokeS jokeS;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Page<Joke> getAll(@RequestParam(value = "filter", required = false, defaultValue = "") String filter, Pageable pageable) {
        return jokeS.getAll(filter, pageable);
    }

    @RequestMapping(value = "/{jokeId}", method = RequestMethod.GET)
    public Joke get(@PathVariable("jokeId") Long id) {
        return jokeS.get(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Joke add(@RequestBody Joke joke) {
        return jokeS.addOrUpdate(joke);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Joke update(@RequestBody Joke joke) {
        return jokeS.addOrUpdate(joke);
    }

    @RequestMapping(value = "/{jokeId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable("jokeId") Long id) {
        jokeS.remove(id);
    }

}
