package com.example.footballworldcupscoreboardapp;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ScoreBoard {

    private Map<Integer, Game> gamesList = new HashMap<>();

    public void addGame(Game game) {
        gamesList.put(game.getId(), game);
    }

    public int gamesNumber() {
        return gamesList.size();
    }

    public Game getGame(int id) {
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

    public void markGameAsOver(int id) {
        getGame(id).endGame();
    }

    public void displayScores() {
        AtomicInteger counter = new AtomicInteger();
        counter.incrementAndGet();
        if (!gamesList.isEmpty()) {
            gamesList.values().stream()
                    .filter(game -> !game.isGameOver()).sorted(Comparator.comparing(Game::getTotalScore)
                            .thenComparing(Game::getGameDate))
                    .forEach(game -> System.out.println(counter.getAndIncrement() + " " + game.getHomeTeamName() + " " + game.getHomeScore() + " - "
                            + game.getAwayTeamName() + " " + game.getAwayScore()));
        }
    }
}
