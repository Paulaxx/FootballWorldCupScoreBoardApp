package com.example.footballworldcupscoreboardapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class CommandLineServiceTest {

    private BoardService boardService;
    private CommandLineService commandLineService;

    @BeforeEach
    public void setUp() {
        boardService = Mockito.mock(BoardService.class);
        commandLineService = new CommandLineService(boardService);
    }

    @Test
    public void testGettingSummary(){
        commandLineService.handleUserInput(4);
        verify(boardService).displayScoreBoard();
    }

    @Test
    public void testWrongInstruction(){
        commandLineService.handleUserInput(6);
        verifyNoInteractions(boardService);
    }

    @Test
    public void testNoGames(){
        when(boardService.checkIfGamesExist()).thenReturn(false);
        commandLineService.handleUserInput(2);
        verify(boardService, times(1));
    }

    @Test
    public void testNoUpdates(){
        when(boardService.checkIfGamesExist()).thenReturn(false);
        commandLineService.handleUserInput(3);
        verify(boardService, never()).updateGame(Mockito.any(), Mockito.any(), Mockito.any());
    }

}
