package com.example.footballworldcupscoreboardapp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ScoreBoard {

    private Map<Integer, Game> gamesList = new HashMap<>();

    public void addGame(Game game) {
        gamesList.put(game.getId(), game);
    }

    public int gamesNumber() {
        return gamesList.size();
    }

    public Object getGame(int id) {
        return gamesList.get(id);
    }

    public void updateScore(int id, String teamName, int score) {
        gamesList.values().stream()
                .filter(game -> game != null && Objects.equals(game.getId(), id))
                .findFirst()
                .ifPresent(game -> {
                    if (game.getAwayTeamName().equals(teamName)) {
                        game.updateAwayScore(score);
                    } else if (game.getHomeTeamName().equals(teamName)) {
                        game.updateHomeScore(score);
                    }
                });
    }

    public boolean gameExists(Integer id) {
        return gamesList.containsKey(id);
    }
}
