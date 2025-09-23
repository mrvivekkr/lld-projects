package com.lld.blackjack.state;

import com.lld.blackjack.model.BlackjackGame;

public class InitialDealState implements GameState {
    @Override
    public void startGame(BlackjackGame game) {
        game.dealInitialCards();
        game.showInitialCards();
        game.setGameState(new PlayerTurnState());
        game.getGameState().playerTurn(game);
    }

    @Override
    public void playerTurn(BlackjackGame game) {
        throw new IllegalStateException("Cannot perform player turn before initial deal completes");
    }

    @Override
    public void dealerTurn(BlackjackGame game) {
        throw new IllegalStateException("Cannot perform dealer turn before player turn");
    }

    @Override
    public void determineWinner(BlackjackGame game) {
        throw new IllegalStateException("Cannot determine winner before game ends");
    }
}
