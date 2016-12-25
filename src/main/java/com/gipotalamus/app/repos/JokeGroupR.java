package com.gipotalamus.app.repos;

import com.gipotalamus.app.entities.JokeGroup;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by gipotalamus on 28.11.16.
 */
public interface JokeGroupR extends JpaRepository<JokeGroup, Long> {
    JokeGroup findOneByName(String name);
}
