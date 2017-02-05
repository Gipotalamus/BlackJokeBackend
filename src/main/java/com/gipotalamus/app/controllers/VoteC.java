package com.gipotalamus.app.controllers;

import com.gipotalamus.app.entities.Vote;
import com.gipotalamus.app.services.VoteS;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/")
    public List<Vote> getVotes() {
        return voteS.getVotes();
    }
}
