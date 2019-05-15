package com.epam.belote.cards;

public class Card {
    private final CardType type;
    private final CardSuit suit;

    public Card(CardType type, CardSuit suit) {
        this.type = type;
        this.suit = suit;
    }

    public CardType getType() {
        return type;
    }

    public CardSuit getSuit() {
        return suit;
    }

    @Override
    public int hashCode() {
        return type.name().hashCode() + suit.name().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return type == card.type &&
                suit == card.suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "type=" + type +
                ", suit=" + suit +
                '}';
    }
}
