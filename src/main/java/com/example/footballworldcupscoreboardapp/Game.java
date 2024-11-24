package com.example.footballworldcupscoreboardapp;

public class Game {

    private static int idCounter = 1;
    private final int id;
    private Team homeTeam;
    private Team awayTeam;
    private int homeScore;
    private int awayScore;
    private boolean gameOver;

    public Game(Team homeTeam, Team awayTeam) {
        this.id = idCounter++;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        homeScore = 0;
        awayScore = 0;
    }

    public int getId() {
        return id;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void updateHomeScore(int newScore) {
        homeScore = newScore;
    }
    public void updateAwayScore(int newScore) {
        awayScore = newScore;
    }

    public int getTotalScore() {
        return homeScore + awayScore;
    }

    public void endGame(){
        gameOver = true;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public String getHomeTeamName() {
        return homeTeam.getName();
    }

    public String getAwayTeamName() {
        return awayTeam.getName();
    }
}
