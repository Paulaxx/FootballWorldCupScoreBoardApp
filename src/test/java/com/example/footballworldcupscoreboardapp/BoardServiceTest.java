package com.example.footballworldcupscoreboardapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class BoardServiceTest {

    private BoardService boardService;


    @BeforeEach
    public void setUp() {
        boardService = mock(BoardService.class);
    }

    @Test
    public void testAddingNewGame() {
        boardService.newGame("home", "away");
        assertTrue(boardService.checkIfGamesExist());
        assertTrue(boardService.checkIfGameIdExist(1));
    }

    @Test
    public void testEndingGame() {
        when(boardService.checkIfGameIdExist(1)).thenReturn(true);
        doNothing().when(boardService).endGame("1");
        assertTrue(boardService.checkIfGameIdExist(1));
    }
}
