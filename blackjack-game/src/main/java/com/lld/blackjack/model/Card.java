package com.lld.blackjack.model;

import com.lld.blackjack.enums.Rank;
import com.lld.blackjack.enums.Suit;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class Card {
    private final Suit suit;
    private final Rank rank;

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", rank=" + rank +
                '}';
    }
}
