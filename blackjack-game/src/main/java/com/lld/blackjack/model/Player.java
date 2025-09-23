package com.lld.blackjack.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public abstract class Player {
    private final  int id;
    @Setter
    protected String name;
    @Getter
    private final Hand hand;

    abstract void play(final Deck deck);

    public boolean isBust(){
        return hand.getScore()>21;
    }
}
