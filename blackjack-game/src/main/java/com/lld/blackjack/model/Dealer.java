package com.lld.blackjack.model;

public class Dealer extends Player {
    public Dealer(int id, Hand hand) {
        super(id, hand);
    }

    @Override
    void play(Deck deck) {
        System.out.println("Dealer's turn");
        while(this.getHand().getScore()<17){
            final Card card = deck.dealCard();
            getHand().addCard(card);
            System.out.println("Dealer's hand "+getHand());
        }
        if(getHand().isBust()){
            System.out.println("Dealer is Bust");
            return;
        }
        System.out.println("Dealer stand with hand "+getHand());
    }
}
