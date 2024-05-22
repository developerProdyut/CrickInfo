package com.cricketscore.ap.CricletScoreBackend.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cricketscore.ap.CricletScoreBackend.Servic.MatchServices;
import com.cricketscore.ap.CricletScoreBackend.entities.Match;
@RestController
@RequestMapping("/match")
@CrossOrigin("*")
public class CricketController {

    private MatchServices matchServices;

    public CricketController(MatchServices matchServices) {
        this.matchServices = matchServices;
    }

    // api for getting live matches

    @GetMapping("/live")
    public ResponseEntity<?> getLiveMatchScores() throws InterruptedException {
        System.out.println("getting live match");
        return new ResponseEntity<>(this.matchServices.getLiveMatches(), HttpStatus.OK);
    }

    @GetMapping("/point-table")
    public ResponseEntity<?> getPointTable() {
        return new ResponseEntity<>(this.matchServices.getPointTable(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Match>> getAllMatches() {
        return new ResponseEntity<>(this.matchServices.getAllMatches(), HttpStatus.OK);
    }
}
