package com.cricketscore.ap.CricletScoreBackend.Servic.Implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.cricketscore.ap.CricletScoreBackend.Repositories.matchRepo;
import com.cricketscore.ap.CricletScoreBackend.Servic.MatchServices;
import com.cricketscore.ap.CricletScoreBackend.entities.Match;

@Service
public class MatchServiceImplementation implements MatchServices{

    private matchRepo matchRepo;
    
    public MatchServiceImplementation(matchRepo matchRepo) {
        this.matchRepo = matchRepo;
    }
//Mach History all matches in our Database
    @Override
    public List<Match> getAllMatches() {
        return this.matchRepo.findAll();
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getAllMatches'");
    }

    @Override
    public List<Match> getLiveMatches() {
        List<Match> matches = new ArrayList<>();
        try {
            String url = "https://www.cricbuzz.com/cricket-match/live-scores";
            Document document = Jsoup.connect(url).get();
            Elements liveScoreElements = document.select("div.cb-mtch-lst.cb-tms-itm");
            for (Element match : liveScoreElements) {
                HashMap<String, String> liveMatchInfo = new LinkedHashMap<>();
                String teamsHeading = match.select("h3.cb-lv-scr-mtch-hdr").select("a").text();
                String matchNumberVenue = match.select("span").text();
                Elements matchBatTeamInfo = match.select("div.cb-hmscg-bat-txt");
                String battingTeam = matchBatTeamInfo.select("div.cb-hmscg-tm-nm").text();
                String score = matchBatTeamInfo.select("div.cb-hmscg-tm-nm+div").text();
                Elements bowlTeamInfo = match.select("div.cb-hmscg-bwl-txt");
                String bowlTeam = bowlTeamInfo.select("div.cb-hmscg-tm-nm").text();
                String bowlingTeamScore = bowlTeamInfo.select("div.cb-hmscg-tm-nm+div").text();
                String textLive = match.select("div.cb-text-live").text();
                String textComplete = match.select("div.cb-text-complete").text();
                //getting match link
                String matchLink = match.select("a.cb-lv-scrs-well.cb-lv-scrs-well-live").attr("href").toString();

                Match match1 = new Match();
                match1.setTeamHeading(teamsHeading);
                match1.setMatchNumberVanue(matchNumberVenue);
                match1.setBattingTeam(battingTeam);
                match1.setBattingTeamScore(score);
                match1.setBowlingTeam(bowlTeam);
                match1.setBowlingTeamScore(bowlingTeamScore);
                match1.setLiveText(textLive);
                match1.setMatchLink(matchLink);
                match1.setTextComplete(textComplete);
                match1.setMatchStatus();


                matches.add(match1);

//                update the match in database
                updateMatchInDb(match1);


                //updateMatch(match1);
                
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matches;
    }
    private void updateMatchInDb(Match match1){

       Match match= this.matchRepo.findByTeamHeading(match1.getTeamHeading()).orElse(null);
       if(match==null){
        matchRepo.save(match1);
       }else{
        match1.setMatchId(match.getMatchId());
        matchRepo.save(match1);
       }
    }


    @Override
    public List<List<String>> getPointTable() {
        List<List< String>> pointTable = new ArrayList<>();
        String tableURL = "https://www.cricbuzz.com/cricket-series/7607/indian-premier-league-2024/points-table";
        try {
            Document document = Jsoup.connect(tableURL).get();
            Elements table = document.select("table.cb-srs-pnts");
            Elements tableHeads = table.select("thead>tr>*");
            List<String> headers = new ArrayList<>();
            tableHeads.forEach(element -> {
                headers.add(element.text());
            });
            pointTable.add(headers);
            Elements bodyTrs = table.select("tbody>*");
            bodyTrs.forEach(tr -> {
                List<String> points = new ArrayList<>();
                if (tr.hasAttr("class")) {
                    Elements tds = tr.select("td");
                    String team = tds.get(0).select("div.cb-col-84").text();
                    points.add(team);
                    tds.forEach(td -> {
                        if (!td.hasClass("cb-srs-pnts-name")) {
                            points.add(td.text());
                        }
                    });
//                    System.out.println(points);
                    pointTable.add( points);
                }


            });

            System.out.println(pointTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pointTable;

        
    

        // TODO Auto-generated method stub
       //throw new UnsupportedOperationException("Unimplemented method 'getPointTable'");
    }

}