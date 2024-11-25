package com.example.footballworldcupscoreboardapp;

import java.util.Scanner;

public class CommandLineService {

    private final Scanner scanner;
    private final BoardService boardService;

    public CommandLineService(BoardService boardService) {
        this.scanner = new Scanner(System.in);
        this.boardService = boardService;
    }

    public void startInteraction(){
        handleUserInput(Integer.parseInt(scanner.nextLine()));
    }

    public void handleUserInput(int userChoice){
        switch(userChoice){
            case 1:
                displayNewGameInstructions();
                String[] teamsNames = getTeamsNames(scanner.nextLine());
                boardService.newGame(teamsNames[0], teamsNames[1]);
                break;
            case 2:
                if(!boardService.checkIfGamesExist()){
                    displayEmptyBoardMessage();
                    break;
                }
                displayEndGameInstructions();
                String gameId = scanner.nextLine();
                boardService.endGame(gameId);
                break;
            case 3:
                if(!boardService.checkIfGamesExist()){
                    displayEmptyBoardMessage();
                    break;
                }
                displayUpdateGameInstructions();
                boardService.displayScoreBoard();
                String gameId2 = scanner.nextLine();
                displayTeamChoiceInstructions();
                String teamChoice = scanner.nextLine();
                displayNewPointsInstructions();
                String points = scanner.nextLine();
                boardService.updateGame(gameId2, teamChoice, points);
                break;
            case 4:
                boardService.displayScoreBoard();
                break;
            default:
                displayWrongInstruction();
        }
    }

    private void displayNewGameInstructions(){
        System.out.println("\nInsert teams names, separated by space\n");
    }

    private void displayEndGameInstructions(){
        System.out.println("\nInsert id of the game to finish\n");
    }

    private void displayUpdateGameInstructions(){
        System.out.println("\nInsert id of the game to update and team name (separated by space)\n");
    }

    private void displayTeamChoiceInstructions(){
        System.out.println("\nInsert team name which should be updated\n");
    }

    private void displayNewPointsInstructions(){
        System.out.println("\nInsert how many points should be added\n");
    }

    private String[] getTeamsNames(String teamsNames){
        return teamsNames.split(" ");
    }

    private void displayEmptyBoardMessage(){
        System.out.println("\nYou have no game saved yet\n");
    }

    private void displayWrongInstruction(){
        System.out.println("\nInvalid number\n");
    }
}
