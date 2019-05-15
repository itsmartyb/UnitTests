package com.epam.belote;

import com.epam.belote.bonus.Belote;
import com.epam.belote.bonus.Bonus;
import com.epam.belote.bonus.Quad;
import com.epam.belote.bonus.Sequence;
import com.epam.belote.cards.Card;
import com.epam.belote.cards.CardSuit;
import com.epam.belote.cards.CardType;
import com.epam.belote.cards.Deck;

import java.util.*;


public class CardPlayer implements Player {
    private static final int MAX_HAND_CARDS = 8;
    private static final int CARDS_FOR_QUAD = 4;
    private List<Card> handCards;
    private Team team;


    public CardPlayer(Team team) {
        this.team = team;
        this.handCards = new ArrayList<>(MAX_HAND_CARDS);
    }

    @Override
    public void addCard(Card card) {
        this.handCards.add(card);
    }

    public void throwCards(Deck deck) {
        for(Card card: this.handCards) {
            deck.addCard(card);
        }
        this.handCards.clear();
    }

    @Override
    public Bid bid() {
        return Bid.values()[new Random().nextInt(7)];
    }

    private void addQuad(Set<Bonus> bonuses) {
        Map<CardType, Integer> quadBonusCards = new HashMap<CardType, Integer>();
        for(Card card : this.handCards) {
            if(quadBonusCards.containsKey(card.getType())) {
                quadBonusCards.put(card.getType(), quadBonusCards.get(card.getType()) + 1);
            } else {
                quadBonusCards.put(card.getType(), 1);
            }
        }
        for(Map.Entry<CardType, Integer> entry : quadBonusCards.entrySet()) {
            if (entry.getValue() == CARDS_FOR_QUAD) {
                bonuses.add(new Quad(entry.getKey()));
            }
        }
    }

    private void sortCards(Map<CardSuit, List<CardType>> cards) {
        for (Card card : this.handCards) {
            if (!cards.containsKey(card.getSuit())) {
                cards.put(card.getSuit(), new ArrayList<>());
            }
            cards.get(card.getSuit()).add(card.getType());
        }
    }

    private void addSequence(Set<Bonus> bonuses) {
        Map<CardSuit, List<CardType>> sequenceCards = new HashMap<>();
        sortCards(sequenceCards);
        for(Map.Entry<CardSuit, List<CardType>> cardsEntry: sequenceCards.entrySet()) {
            List<CardType> cardTypes = cardsEntry.getValue();
            Collections.sort(cardTypes, (Comparator.comparingInt(CardType::getCardValue)));
            int startIndex = 0;
            int endIndex = 0;
                for(int i = 0; i < cardTypes.size() - 1; i++) {
                    if (cardTypes.get(i).getCardValue() - cardTypes.get(i + 1).getCardValue() == -1) {
                        endIndex++;
                    } else {
                        addSequenceInBonuses(startIndex, endIndex, bonuses, cardTypes);
                        endIndex++;
                        startIndex = endIndex;
                    }
                }
            addSequenceInBonuses(startIndex, endIndex, bonuses, cardTypes);
        }
    }

    private void addSequenceInBonuses(int startIndex, int endIndex, Set<Bonus> bonuses, List<CardType> cardTypes) {
        if (endIndex - startIndex >= 2) {
            List<CardType> sequence = new ArrayList<>();
            for (int index = startIndex; index <= endIndex; index++) {
               sequence.add(cardTypes.get(index));
            }
            bonuses.add(new Sequence(sequence));
        }
    }

    private void addBelote(Set<Bonus> bonuses) {
        Map<CardSuit, List<CardType>> beloteCards = new HashMap<>();
        sortCards(beloteCards);
        for(Map.Entry<CardSuit, List<CardType>> cardsEntry: beloteCards.entrySet()) {
            List<CardType> cardsFromSuit = new ArrayList<>(cardsEntry.getValue());
            if(cardsFromSuit.size() >= 2) {
                for(int index = 0; index < cardsFromSuit.size() - 1; index++) {
                    bonuses.add(new Belote(new Card(cardsFromSuit.get(index), cardsEntry.getKey()),
                            new Card(cardsFromSuit.get(index + 1), cardsEntry.getKey())));
                }
            }
        }
    }

    @Override
    public Set<Bonus> declareBonus() {
        Set<Bonus> bonuses = new HashSet<Bonus>();
        addQuad(bonuses);
        addSequence(bonuses);
        addBelote(bonuses);
        return bonuses;
    }

    public Card playCard() {
        int random = new Random().nextInt(this.handCards.size());
        Card card = this.handCards.get(random);
        this.handCards.remove(random);
        return card;
    }

    public int getHandSize() {
        return this.handCards.size();
    }

    public List<Card> getPlayerHandCards() {
        return new ArrayList<>(this.handCards);
    }

    @Override
    public Team getTeam() {
        return this.team;
    }
}
