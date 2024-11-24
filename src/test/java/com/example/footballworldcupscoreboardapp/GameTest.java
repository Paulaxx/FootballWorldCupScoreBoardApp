package com.example.footballworldcupscoreboardapp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameTest {

    private Team homeTeam;
    private Team awayTeam;
    private Game game;

    @BeforeEach
    public void setUp() {
        homeTeam = Mockito.mock(Team.class);
        awayTeam = Mockito.mock(Team.class);

        Mockito.when(homeTeam.getName()).thenReturn("home");
        Mockito.when(awayTeam.getName()).thenReturn("away");

        game = new Game(homeTeam, awayTeam);
    }

    @Test
    public void testGameInitialization() {
        assertNotNull(game);
        assertEquals(1, game.getId());
        assertFalse(game.isGameOver());
    }
}
