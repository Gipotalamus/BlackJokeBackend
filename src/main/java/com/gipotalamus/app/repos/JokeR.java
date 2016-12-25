package com.gipotalamus.app.repos;

import com.gipotalamus.app.entities.Joke;
import com.gipotalamus.app.entities.JokeGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by gipotalamus on 28.11.16.
 */
public interface JokeR extends JpaRepository<Joke, Long> {
    Page<Joke> findByJokeGroup(JokeGroup group, Pageable pageable);
}
