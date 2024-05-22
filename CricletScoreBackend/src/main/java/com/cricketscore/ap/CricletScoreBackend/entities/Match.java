package com.cricketscore.ap.CricletScoreBackend.entities;
import java.util.Date;

import org.springframework.beans.factory.config.YamlProcessor.MatchStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "cricket_matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchId;

    private String teamHeading;
    private String matchNumberVanue;
    private String battingTeam;
    private String battingTeamScore;
    private String bowlingTeam;
    private String bowlingTeamScore;
    private String liveText;
    private String matchLink;
    private String textComplete;

    @Enumerated
    private matchStatus status;
    private Date date=new Date();
    public Match(int matchId, String teamHeading, String matchNumberVanue, String battingTeam, String battingTeamScore,
            String bowlingTeam, String bowlingTeamScore, String liveText, String matchLink, String textComplete,
            matchStatus status, Date date) {
        this.matchId = matchId;
        this.teamHeading = teamHeading;
        this.matchNumberVanue = matchNumberVanue;
        this.battingTeam = battingTeam;
        this.battingTeamScore = battingTeamScore;
        this.bowlingTeam = bowlingTeam;
        this.bowlingTeamScore = bowlingTeamScore;
        this.liveText = liveText;
        this.matchLink = matchLink;
        this.textComplete = textComplete;
        this.status = status;
        this.date = date;
    }
    public Match() {
        
    }

    public void setMatchStatus(){
        if(textComplete.isBlank()){
            this.status=matchStatus.LIVE;
        }else{
            this.status=matchStatus.COMPLETED;
        }

    }
    public int getMatchId() {
        return matchId;
    }
    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }
    public String getTeamHeading() {
        return teamHeading;
    }
    public void setTeamHeading(String teamHeading) {
        this.teamHeading = teamHeading;
    }
    public String getMatchNumberVanue() {
        return matchNumberVanue;
    }
    public void setMatchNumberVanue(String matchNumberVanue) {
        this.matchNumberVanue = matchNumberVanue;
    }
    public String getBattingTeam() {
        return battingTeam;
    }
    public void setBattingTeam(String battingTeam) {
        this.battingTeam = battingTeam;
    }
    public String getBattingTeamScore() {
        return battingTeamScore;
    }
    public void setBattingTeamScore(String battingTeamScore) {
        this.battingTeamScore = battingTeamScore;
    }
    public String getBowlingTeam() {
        return bowlingTeam;
    }
    public void setBowlingTeam(String bowlingTeam) {
        this.bowlingTeam = bowlingTeam;
    }
    public String getBowlingTeamScore() {
        return bowlingTeamScore;
    }
    public void setBowlingTeamScore(String bowlingTeamScore) {
        this.bowlingTeamScore = bowlingTeamScore;
    }
    public String getLiveText() {
        return liveText;
    }
    public void setLiveText(String liveText) {
        this.liveText = liveText;
    }
    public String getMatchLink() {
        return matchLink;
    }
    public void setMatchLink(String matchLink) {
        this.matchLink = matchLink;
    }
    public String getTextComplete() {
        return textComplete;
    }
    public void setTextComplete(String textComplete) {
        this.textComplete = textComplete;
    }
    public matchStatus getStatus() {
        return status;
    }
    public void setStatus(matchStatus status) {
        this.status = status;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    
    

}
