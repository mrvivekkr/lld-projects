package com.lld.blackjack.application;

import com.lld.blackjack.model.*;
import com.lld.blackjack.state.InitialDealState;
import com.lld.blackjack.strategy.ScoreStrategy;
import com.lld.blackjack.strategy.StandardBlackjackScoreStrategy;

import java.util.Scanner;

public class Application {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Blackjack");
        System.out.println("Please Enter your name");
        String name = scanner.nextLine();

        final ScoreStrategy strategy = new StandardBlackjackScoreStrategy();
        final BlackjackPlayer player = new BlackjackPlayer(1, new Hand(strategy));
        player.setName(name);
        final Dealer dealer = new Dealer(2, new Hand(strategy));
        dealer.setName("Dealer");

        final BlackjackGame game = new BlackjackGame(player,dealer,new Deck(),strategy);
        game.setGameState(new InitialDealState());
        game.getGameState().startGame(game);
    }

}
