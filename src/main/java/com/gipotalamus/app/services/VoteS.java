package com.gipotalamus.app.services;

import com.gipotalamus.app.entities.Vote;
import com.gipotalamus.app.repos.VoteR;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gipotalamus on 05.02.17.
 */
@Service
public class VoteS {
    @Inject
    private VoteR voteR;

    public List<Vote> getVotes() {
        return voteR.findAll();
    }
}