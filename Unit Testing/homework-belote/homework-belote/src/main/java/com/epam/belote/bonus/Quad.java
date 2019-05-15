package com.epam.belote.bonus;

import com.epam.belote.cards.CardType;

/**
 * A Quad bonus is declared whenever the player has 4 cards of the same type, e.g. four Kings
 */
public class Quad implements Bonus {
    private static final int HUNDRED_POINTS_BONUS = 100;
    private static final int BONUS_POINTS_FOR_NINES = 150;
    private static final int BONUS_POINTS_FOR_JACKS = 200;
    private final CardType cardType;

    public Quad(CardType cardType) {
        this.cardType = cardType;
    }

    public CardType getCardType() {
        return cardType;
    }

    public int getBonus() {
        if(this.cardType.equals(CardType.ACE) || this.cardType.equals((CardType.KING))
            || this.cardType.equals(CardType.QUEEN) || this.cardType.equals(CardType.TEN)) {
            return HUNDRED_POINTS_BONUS;
        } else if(this.cardType.equals(CardType.NINE)) {
            return BONUS_POINTS_FOR_NINES;
        } else if (this.cardType.equals(CardType.JACK)) {
            return BONUS_POINTS_FOR_JACKS;
        } else {
            return 0;
        }
    }
}
