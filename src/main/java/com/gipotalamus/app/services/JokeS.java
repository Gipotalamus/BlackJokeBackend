package com.gipotalamus.app.services;

import com.gipotalamus.app.entities.Joke;
import com.gipotalamus.app.entities.JokeGroup;
import com.gipotalamus.app.entities.Vote;
import com.gipotalamus.app.repos.JokeR;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gipotalamus on 28.11.16.
 */
@Service
public class JokeS {
    @Inject
    private JokeR jokeRepo;

    @Inject
    private JokeGroupS jokeGroupS;

    @Inject
    private JokeUserS jokeUserS;

    public Joke addOrUpdate(Joke joke) {
        joke.setJokeGroup(jokeGroupS.getByName(joke.getJokeGroup().getName()));
        joke.setAuthor(jokeUserS.getByName(joke.getAuthor().getName()));
        return jokeRepo.save(joke);
    }

    public void remove(Long id) {
        jokeRepo.delete(id);
    }

    public Page<Joke> getAll(String filter, Pageable pageable) {
        if (filter.equals("")) {
            return jokeRepo.findAll(pageable);
            }
        return jokeRepo.findByJokeGroup(jokeGroupS.getByName(filter), pageable);
    }

    public Joke get(Long id) {
        return jokeRepo.findOne(id);
    }

    public Double calculateRaiting(Joke joke) {
        Double sum = 0d;
        for (Vote vote :
                joke.getVotes()) {
            sum += vote.getVoteValue();
        }
        Integer count = joke.getVotes().size();
        Double r = sum/count;
        joke.setRaiting(r);
        addOrUpdate(joke);
        return r;
    }

}
