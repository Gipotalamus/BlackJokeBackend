package com.gipotalamus.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by gipotalamus on 28.11.16.
 */
@Entity
public class Joke {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    @Column( length = 50000 )
    private String content;

    @ManyToOne
    @JoinColumn(name = "joke_group")
    private JokeGroup jokeGroup;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "author")
    private JokeUser author;

    @OneToMany(mappedBy = "joke")
    @JsonIgnore
    private List<Vote> votes;

    public Joke() {
    }

    public Joke(String content, JokeGroup group, Date date, JokeUser author, List<Vote> votes) {
        this.content = content;
        this.jokeGroup = group;
        this.date = date;
        this.author = author;
        this.votes = votes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public JokeGroup getGroup() {
        return jokeGroup;
    }

    public void setGroup(JokeGroup jokeGroup) {
        this.jokeGroup = jokeGroup;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public JokeUser getAuthor() {
        return author;
    }

    public void setAuthor(JokeUser author) {
        this.author = author;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}
