package com.gipotalamus.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

/**
 * Created by gipotalamus on 28.11.16.
 */
@Entity
public class JokeGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "jokeGroup", orphanRemoval = true)
    @JsonIgnore
    private List<Joke> jokes;

    public JokeGroup() {
    }

    public JokeGroup(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Joke> getJokes() {
        return jokes;
    }

    public void setJokes(List<Joke> jokes) {
        this.jokes = jokes;
    }
}
