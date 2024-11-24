package com.example.footballworldcupscoreboardapp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScoreBoardTest {

    private ScoreBoard scoreBoard;
    private Game game;

    @BeforeEach
    public void setUp() {
        scoreBoard = new ScoreBoard();
        game = mock(Game.class);
        when(game.getId()).thenReturn(1);
        when(game.getHomeTeamName()).thenReturn("home");
        when(game.getAwayTeamName()).thenReturn("away");
    }

    @Test
    public void testAddGame(){
        scoreBoard.addGame(game);
        assertEquals(1, scoreBoard.gamesNumber());
    }

    @Test
    public void testGettingGame(){
        scoreBoard.addGame(game);
        assertNotNull(scoreBoard.getGame(game.getId()));
    }

    @Test
    public void testUpdatingGameScore(){
        scoreBoard.addGame(game);

        scoreBoard.updateScore(game.getId(), game.getHomeTeamName(), 2);
        verify(game, times(1)).updateHomeScore(2);
    }

    @Test
    public void testGameExistence(){
        scoreBoard.addGame(game);
        assertTrue(scoreBoard.gameExists(game.getId()));
    }

    @Test
    public void testGameNotExisting(){
        assertFalse(scoreBoard.gameExists(4));
    }


}
