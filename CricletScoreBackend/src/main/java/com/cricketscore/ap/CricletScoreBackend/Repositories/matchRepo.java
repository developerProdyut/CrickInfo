package com.cricketscore.ap.CricletScoreBackend.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cricketscore.ap.CricletScoreBackend.entities.Match;
import java.util.List;


public interface matchRepo extends JpaRepository<Match,Integer> {

    Optional<Match>findByTeamHeading(String teamHeading);
}
