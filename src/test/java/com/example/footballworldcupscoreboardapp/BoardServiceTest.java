package com.example.footballworldcupscoreboardapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class BoardServiceTest {

    private BoardService boardService;
    private ScoreBoard scoreBoard;
    private Game game;


    @BeforeEach
    public void setUp() {
        scoreBoard = mock(ScoreBoard.class);
        boardService = new BoardService(scoreBoard);
        game = mock(Game.class);
    }

    @Test
    public void testAddingNewGame() {
        boardService.newGame("home", "away");
        verify(scoreBoard, times(1)).addGame(any(Game.class));
    }

    public void testEndingGame() {
        when(scoreBoard.gameExists(1)).thenReturn(true);
        doNothing().when(scoreBoard).markGameAsOver(1);
        scoreBoard.endGame(1);
        verify(scoreBoard, times(1)).markGameAsOver(1);
    }
}
