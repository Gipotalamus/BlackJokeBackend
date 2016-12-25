package com.gipotalamus.app.repos;

import com.gipotalamus.app.entities.JokeUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by gipotalamus on 03.12.16.
 */
public interface JokeUserR extends JpaRepository<JokeUser, Long> {
    JokeUser findByName(String name);
}
