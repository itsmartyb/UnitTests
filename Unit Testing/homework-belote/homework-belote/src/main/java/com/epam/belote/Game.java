package com.epam.belote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private List<CardPlayer> belotePlayers;
    private CardDealer cardDealer;
    private Bid bid;

    public Game(List<CardPlayer> belotePlayers) {
        this.belotePlayers = belotePlayers;
        this.cardDealer = new BeloteCardDealer();
        this.bid = Bid.PASS;
    }

    public void makeBid() {
        for (Player player : this.belotePlayers) {
            Bid bid = player.bid();
            if (bid.compareTo(this.bid) > 0) {
                this.bid = bid;
            }
        }

    }

    private void startGame() {
        for (CardPlayer player : this.belotePlayers) {
            cardDealer.deal5Cards(player);
        }
    }

    public CardDealer getCardDealer() {
        return this.cardDealer;
    }

    public void dealCards() {
        startGame();
        makeBid();
        if (!this.bid.equals(Bid.PASS)) {
            for (CardPlayer player : this.belotePlayers) {
                cardDealer.deal3Cards(player);
            }
        } else {
            for (CardPlayer player : this.belotePlayers) {
                player.throwCards(cardDealer.getDeck());
            }
        }
    }

    public static void main(String[] args) {

        List<CardPlayer> list = new ArrayList<CardPlayer>(Arrays.asList(new CardPlayer(new Team()),new CardPlayer(new Team()),new CardPlayer(new Team()),new CardPlayer(new Team())));
        Game game = new Game(list);
        game.dealCards();
        System.out.println(game.getCardDealer().getDeck().getDeckSize());

    }
}
