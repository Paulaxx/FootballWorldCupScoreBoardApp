package com.example.footballworldcupscoreboardapp;

import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private static ScoreBoard scoreBoard;

    public BoardService() {
        scoreBoard = new ScoreBoard();
    }

    public void newGame(String[] teamsNames) {
        if(checkTeamsNames(teamsNames) == -1){
            return;
        }
        Game game = new Game(new Team(teamsNames[0]), new Team(teamsNames[1]));
        scoreBoard.addGame(game);
    }

    public boolean checkIfGameIdExist(int id){
        return scoreBoard.gameExists(id);
    }

    public boolean checkIfGamesExist(){
        return scoreBoard.gamesNumber() != 0;
    }

    public void endGame(String id){
        int gameId = getIntegerFromUserInput(id);
        if(!checkIfGameIdExist(gameId)){
            System.out.println("The game with id " + id + " does not exist");
            return;
        }
        scoreBoard.markGameAsOver(gameId);
    }

    public void updateGame(String id, String teamChoice, String points){
        int gameId = getIntegerFromUserInput(id);
        if(!checkIfGameIdExist(gameId)){
            System.out.println("The game with id " + id + " does not exist");
            return;
        }
        scoreBoard.updateScore(gameId, teamChoice, getIntegerFromUserInput(points));
    }

    public void displayScoreBoard(){
        scoreBoard.displayScores();
    }

    private int checkTeamsNames(String[] input){
        if (input.length != 2) {
            System.out.println("Invalid format of entered team names");
            return -1;
        }
        return 1;
    }

    public int getIntegerFromUserInput(String gameId){
        try{
            return Integer.parseInt(gameId);
        }
        catch (NumberFormatException e){
            System.out.println("Invalid format of entered data");
        }
        return 0;
    }
}
