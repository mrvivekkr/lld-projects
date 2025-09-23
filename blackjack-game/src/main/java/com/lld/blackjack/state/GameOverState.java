package com.lld.blackjack.state;

import com.lld.blackjack.model.BlackjackGame;

public class GameOverState implements GameState {
    @Override
    public void startGame(BlackjackGame game) {
        throw new IllegalStateException("Game already started");
    }

    @Override
    public void playerTurn(BlackjackGame game) {
        throw new IllegalStateException("Game is over. Player turn is not allowed.");
    }

    @Override
    public void dealerTurn(BlackjackGame game) {
        throw new IllegalStateException("Game is over. Dealer turn is not allowed.");
    }

    @Override
    public void determineWinner(BlackjackGame game) {
        game.determineWinner();
    }
}
