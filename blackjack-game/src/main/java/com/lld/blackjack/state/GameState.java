package com.lld.blackjack.state;

import com.lld.blackjack.model.BlackjackGame;
import com.lld.blackjack.model.BlackjackPlayer;

public interface GameState {
    void startGame(BlackjackGame game);
    void playerTurn(BlackjackGame game);
    void dealerTurn(BlackjackGame game);
    void determineWinner(BlackjackGame game);
}
