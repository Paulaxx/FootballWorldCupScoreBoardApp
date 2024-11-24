package com.example.footballworldcupscoreboardapp;

public class Game {

    private static int idCounter = 1;
    private int id;
    private Team homeTeam;
    private Team awayTeam;
    private int homeScore;
    private int awayScore;
    private boolean gameOver;

    public Game(Team homeTeam, Team awayTeam) {
        this.id = idCounter++;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public int getId() {
        return id;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
