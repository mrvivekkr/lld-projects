package com.lld.blackjack.model;

import java.util.Scanner;

public class BlackjackPlayer extends Player{
    public BlackjackPlayer(int id, Hand hand) {
        super(id, hand);
    }

    @Override
    public void play(final Deck deck) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(name+"'s turn. Player has"+getHand());
        System.out.println("Hit or Stand?");
        String input = scanner.nextLine().trim().toUpperCase();
            if(input.equals("H")) {
                final Card card = deck.dealCard();
                this.getHand().addCard(card);
                System.out.println(name+" choose to Hit"+name+"'s hand "+getHand());
            } else if (input.equals("S")) {
                System.out.println(name+" stands");
            }else {
                System.out.println("Invalid Input. Please enter H or S");
            }
    }
}
