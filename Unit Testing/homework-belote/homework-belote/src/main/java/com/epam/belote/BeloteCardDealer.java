package com.epam.belote;

import com.epam.belote.cards.Deck;

import java.util.Collections;

public class BeloteCardDealer implements CardDealer {
    private static int FIVE_CARDS = 5;
    private static int THREE_CARDS = 3;
    private Deck deck;

    public BeloteCardDealer() {
        this.deck = new Deck();
        this.deck.shuffle();
    }

    @Override
    public void deal5Cards(CardPlayer player) {
        for(int i = 0; i < FIVE_CARDS; i++) {
            player.addCard(deck.getFirstCard());

        }
    }

    @Override
    public void deal3Cards(CardPlayer player) {
        for(int i = 0; i < THREE_CARDS; i++) {
            player.addCard(deck.getFirstCard());
        }
    }

    @Override
    public Deck getDeck() {
        return this.deck;
    }



}
