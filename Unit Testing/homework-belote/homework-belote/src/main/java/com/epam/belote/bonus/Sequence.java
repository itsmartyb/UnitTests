package com.epam.belote.bonus;

import com.epam.belote.cards.CardSuit;
import com.epam.belote.cards.CardType;

import java.util.List;

import static java.util.Collections.unmodifiableList;

/**
 * The Sequence bonus is declared when the player has a sequence of three or more cards of the same suit, for example Jack, Queen and King of Spades
 */
public class Sequence implements Bonus {
    private static final int MIN_CARDS_FOR_BONUS = 3;
    private static final int TWENTY_POINTS = 20;
    private static final int FIFTY_POINTS = 50;
    private static final int HUNDRED_POINTS = 100;

    private final List<CardType> cards;

    public Sequence(List<CardType> cards) {
        this.cards = unmodifiableList(cards);
    }

    public List<CardType> getCards() {
        return cards;
    }

    public int getBonus() {
        if(this.cards.size() >= MIN_CARDS_FOR_BONUS) {
            switch(this.cards.size()) {
                case 3:
                    return TWENTY_POINTS;
                case 4:
                    return FIFTY_POINTS;
                default:
                    return HUNDRED_POINTS;
            }
        }
        throw new UnsupportedOperationException("Cannot have sequence with less than 3 cards.");

    }
}
