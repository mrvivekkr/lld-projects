package com.lld.blackjack.strategy;

import com.lld.blackjack.model.Card;

import java.util.List;

public interface ScoreStrategy {
    int calculateScore(final List<Card> cards);
}
