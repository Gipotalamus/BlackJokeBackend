package com.gipotalamus.app.controllers;

import com.gipotalamus.app.entities.JokeUser;
import com.gipotalamus.app.entities.Vote;
import com.gipotalamus.app.services.JokeUserS;
import com.gipotalamus.app.services.VoteS;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gipotalamus on 05.02.17.
 */
@RestController
@RequestMapping("/votes")
@CrossOrigin
public class VoteC {

    @Inject
    private VoteS voteS;

    @Inject
    private JokeUserS userS;


    @RequestMapping("")
    public List<Vote> getUserVotes(@RequestParam("user") String  name) {
        JokeUser user = userS.getByName(name);
        return voteS.getByUser(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Vote add(@RequestBody Vote vote) {
        System.out.println(vote.getJokeUser().getName());
        return voteS.add(vote);
    }
}
