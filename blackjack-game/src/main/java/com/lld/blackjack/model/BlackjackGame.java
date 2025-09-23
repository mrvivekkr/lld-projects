package com.lld.blackjack.model;

import com.lld.blackjack.state.GameState;
import com.lld.blackjack.strategy.ScoreStrategy;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
@Setter
@Getter
public class BlackjackGame {
    private final BlackjackPlayer player;
    private final Dealer dealer;
    private final Deck deck;
    private final ScoreStrategy scoreStrategy;
    private GameState gameState;


    public void determineWinner() {
        final int dealerScore = dealer.getHand().getScore();
        final int playerScore = player.getHand().getScore();
        if(playerScore>dealerScore){
            System.out.println("Player Wins");
        } else if (dealerScore>playerScore) {
            System.out.println("Dealer Wins!");
        }else{
            System.out.println("Its a tie");
        }
    }

    public void showInitialCards() {
        System.out.println("Players hand "+player.getHand().getCards());
        System.out.println("Dealers Hand "+dealer.getHand().getCards());
    }

    public void dealInitialCards() {
        dealer.getHand().addCard(deck.dealCard());
        dealer.getHand().addCard(deck.dealCard());
        player.getHand().addCard(deck.dealCard());
        player.getHand().addCard(deck.dealCard());
    }
}
