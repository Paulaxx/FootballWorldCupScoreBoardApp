package com.example.footballworldcupscoreboardapp;

public class BoardService {

    private static ScoreBoard scoreBoard;

    public BoardService() {
        scoreBoard = new ScoreBoard();
    }

    public void newGame(String homeTeam, String awayTeam) {
        Game game = new Game(new Team(homeTeam), new Team(awayTeam));
        scoreBoard.addGame(game);
    }

    public boolean checkIfGameIdExist(int id){
        return scoreBoard.gameExists(id);
    }

    public boolean checkIfGamesExist(){
        return scoreBoard.gamesNumber() != 0;
    }

    public void endGame(String id){
        scoreBoard.markGameAsOver(Integer.parseInt(id));
    }

    public void updateGame(String id, String teamChoice, String points){
        scoreBoard.updateScore(Integer.parseInt(id), teamChoice, Integer.parseInt(points));
    }

    public void displayScoreBoard(){
        scoreBoard.displayScores();
    }
}
