package com.lld.blackjack.state;

import com.lld.blackjack.model.BlackjackGame;
import com.lld.blackjack.model.Card;

public class DealerTurnState implements GameState{
    @Override
    public void startGame(BlackjackGame game) {
        throw new IllegalStateException("Game already started");
    }

    @Override
    public void playerTurn(BlackjackGame game) {
        throw new IllegalStateException("Player turn already completed");
    }

    @Override
    public void dealerTurn(BlackjackGame game) {
        System.out.println("Dealer's turn started");
        if(game.getDealer().getHand().getScore()<17){
            final Card card = game.getDeck().dealCard();
            game.getDealer().getHand().addCard(card);
            System.out.println("Dealer hits. Dealer's hand "+game.getDealer().getHand());
            if(game.getDealer().isBust()){
                System.out.println("Dealer Busted! Player wins");
                game.setGameState(new GameOverState());
            }else{
                game.setGameState(new PlayerTurnState());
                game.getGameState().playerTurn(game);
            }
        }else {
            System.out.println("Dealer stands with hand " + game.getDealer().getHand());
            game.setGameState(new GameOverState());
            game.getGameState().determineWinner(game);
        }
    }

    @Override
    public void determineWinner(BlackjackGame game) {
        throw new IllegalStateException("Cannot determine winner before game ends");
    }
}
