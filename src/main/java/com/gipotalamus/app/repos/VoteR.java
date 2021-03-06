package com.gipotalamus.app.repos;

import com.gipotalamus.app.entities.JokeUser;
import com.gipotalamus.app.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by gipotalamus on 05.02.17.
 */

public interface VoteR extends JpaRepository<Vote, Long> {
    List<Vote> findByJokeUser(JokeUser user);

}
