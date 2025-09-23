package com.lld.blackjack.state;

import com.lld.blackjack.model.BlackjackGame;
import com.lld.blackjack.model.BlackjackPlayer;

public class PlayerTurnState implements GameState {
    @Override
    public void startGame(BlackjackGame game) {
        throw new IllegalStateException("Game already started");
    }

    @Override
    public void playerTurn(BlackjackGame game) {
        System.out.println("Player's turn started");
        final BlackjackPlayer player = game.getPlayer();
        player.play(game.getDeck());
        if(player.isBust()){
            System.out.println("Player is Busted");
            game.setGameState(new GameOverState());
            System.out.println("Game Over !! Dealer wins");
            game.setGameState(new GameOverState());
        }else {
            game.setGameState(new DealerTurnState());
            game.getGameState().dealerTurn(game);
        }
    }

    @Override
    public void dealerTurn(BlackjackGame game) {
        throw new IllegalStateException("Dealer turn already completed");
    }

    @Override
    public void determineWinner(BlackjackGame game) {
        throw new IllegalStateException("Cannot determine winner before game ends");
    }
}
