package edu.cmu.cs.cs214.rec10.plugin;

import edu.cmu.cs.cs214.rec10.framework.core.GameFramework;
import edu.cmu.cs.cs214.rec10.framework.core.GamePlugin;
import edu.cmu.cs.cs214.rec10.games.TicTacToe;

public class TTTPlugin implements GamePlugin<TicTacToe.Player>{
    private static final String GAME_NAME = "Tic Tac Toe";
    private static final String UNKNOWN_SQUARE_STRING = "?";
    private static final String BLANK_SQUARE_STRING = "";
    private static final String SELECT_FIRST_CARD_MSG = "Select first card.";
    private static final String SELECT_SECOND_CARD_MSG = "Select second card.";
    private static final String MATCH_FOUND_MSG = "You found a match!  Select first card.";
    private static final String NOT_A_MATCH_MSG = "That was not a match.  Select first card.";
    private static final String PLAYER_WON_MSG = "Player %d won!";
    private static final String PLAYERS_TIED_MSG = "Players %s tied.";

    private GameFramework framework;
    private TicTacToe game;

    @Override
    public String getGameName() {
        return GAME_NAME;
    }

    @Override
    public int getGridWidth() {
        return TicTacToe.SIZE;
    }

    @Override
    public int getGridHeight() {
        return TicTacToe.SIZE;
    }

    @Override
    public void onRegister(GameFramework framework) {
        this.framework = framework;
        
    }

    @Override
    public void onNewGame() {
        framework.setFooterText("Let's play Tic Tac Toe");
        game = new TicTacToe();        
    }

    @Override
    public void onNewMove() {
        // do nothing   
    }

    @Override
    public boolean isMoveValid(int x, int y) {
        return game.isValidPlay(x, y);
    }

    @Override
    public boolean isMoveOver() {
        return true;
    }

    @Override
    public void onMovePlayed(int x, int y) {
        framework.setSquare(x, y, game.currentPlayer().toString());
        game.play(x, y);
    }

    @Override
    public boolean isGameOver() {
        return game.isOver();
    }

    @Override
    public String getGameOverMessage() {
        TicTacToe.Player winner = game.winner();
        return null;
    }

    @Override
    public void onGameClosed() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public TicTacToe.Player currentPlayer() {
        // TODO Auto-generated method stub
        return game.currentPlayer();
    }
    
}

