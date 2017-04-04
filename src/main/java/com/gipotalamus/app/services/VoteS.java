package com.gipotalamus.app.services;

import com.gipotalamus.app.entities.JokeUser;
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

    @Inject
    JokeUserS userS;

    @Inject
    private JokeS jokeS;

    public List<Vote> getAll() {
        return voteR.findAll();
    }

    public List<Vote> getByUser(JokeUser user) {
        return voteR.findByJokeUser(user);
    }

    public Vote add(Vote vote) {
        vote.setJokeUser(userS.getByName(vote.getJokeUser().getName()));
        Vote v = voteR.save(vote);
        jokeS.calculateRaiting(vote.getJoke(), vote.getVoteValue());
        return v;
    }
}
