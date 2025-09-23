package com.lld.blackjack.model;

import com.lld.blackjack.strategy.ScoreStrategy;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    @Getter
    private final List<Card> cards = new ArrayList<>();
    private final ScoreStrategy scoreStrategy;

    public Hand(ScoreStrategy scoreStrategy) {
        this.scoreStrategy = scoreStrategy;
    }

    public int getScore() {
        return scoreStrategy.calculateScore(cards);
    }

    public void addCard(final Card card) {
        cards.add(card);
    }

    public boolean isBust() {
        return getScore()>21;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards.toString() +
                '}';
    }
}
