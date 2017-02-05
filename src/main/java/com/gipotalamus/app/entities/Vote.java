package com.gipotalamus.app.entities;

import javax.persistence.*;

/**
 * Created by gipotalamus on 05.02.17.
 */
@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user")
    private JokeUser jokeUser;

    @ManyToOne
    @JoinColumn(name = "joke")
    private Joke joke;

    private double votesValue;

    public Vote() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JokeUser getJokeUser() {
        return jokeUser;
    }

    public void setJokeUser(JokeUser jokeUser) {
        this.jokeUser = jokeUser;
    }

    public Joke getJoke() {
        return joke;
    }

    public void setJoke(Joke joke) {
        this.joke = joke;
    }

    public double getVotesValue() {
        return votesValue;
    }

    public void setVotesValue(double votesValue) {
        this.votesValue = votesValue;
    }
}