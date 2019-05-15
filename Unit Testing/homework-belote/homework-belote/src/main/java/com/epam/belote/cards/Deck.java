package com.epam.belote.cards;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private static final int MAX_CARDS = 32;
    private List<Card> cards = new ArrayList<Card>(MAX_CARDS);

    public Deck() {
        for(CardType type : CardType.values()) {
            for(CardSuit suit: CardSuit.values()) {
                cards.add(new Card(type, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    private void transferCards(List<Card> cards, int howMany) {
        for(int i = 0; i <= howMany; i++) {
            cards.add(this.cards.get(i));
        }
    }


    private void completeCut(List<Card> cards, int index) {
        int writeIndex = 0;
        for(int i = MAX_CARDS - index - 1; i < MAX_CARDS; ++i) {
            this.cards.set(i, cards.get(writeIndex++));
        }
    }


    public void cut() {
        final int cutInTenthCard = 9;
        List<Card> cards = new ArrayList<>(cutInTenthCard + 1);
        transferCards(cards, cutInTenthCard);
        for(int i = cutInTenthCard + 1; i < MAX_CARDS; ++i) {
            this.cards.set(i - cutInTenthCard - 1, this.cards.get(i));
        }
        completeCut(cards, cutInTenthCard);
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public Card getFirstCard() {
        Card card = this.cards.get(0);
        this.cards.remove(0);
        return card;
    }

    public Card getCard(int index) {
        if(index >= 0 && index < MAX_CARDS) {
            return this.cards.get(index);
        }
        throw new IndexOutOfBoundsException("Invalid index in card deck!");
    }

    public int getDeckSize() {
        return this.cards.size();
    }
}
