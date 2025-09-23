package com.lld.blackjack.model;

import com.lld.blackjack.enums.Rank;
import com.lld.blackjack.enums.Suit;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// Deck need to be singleton? Why?
public class Deck {
    private final Stack<Card> cards =  new Stack();

    public Deck() {
        initializeAndShuffle();
    }

    private void initializeAndShuffle() {
        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                cards.add(new Card(suit,rank));
            }
        }
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        if(cards.isEmpty())
            initializeAndShuffle();;
        return cards.pop();
    }
}
