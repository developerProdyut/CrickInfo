package com.cricketscore.ap.CricletScoreBackend.Servic;

import java.util.List;
import java.util.Map;

import com.cricketscore.ap.CricletScoreBackend.entities.Match;

public interface MatchServices {
    //get all matches
    List<Match>getAllMatches();
    List<Match>getLiveMatches();
    List<List<String>>getPointTable();

}
