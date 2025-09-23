package com.lld.blackjack.strategy;

import com.lld.blackjack.enums.Rank;
import com.lld.blackjack.model.Card;

import java.util.List;

public class StandardBlackjackScoreStrategy implements ScoreStrategy {

    @Override
    public int calculateScore(List<Card> cards) {
        int score = 0;
        int aceCount = 0;
        for(Card card: cards){
            score+= card.getRank().getValue();
            if(card.getRank() == Rank.ACE)
                aceCount++;
        }
        while(score>21 && aceCount>0){
            score-=10;
            aceCount--;
        }
        return score;
    }
}
