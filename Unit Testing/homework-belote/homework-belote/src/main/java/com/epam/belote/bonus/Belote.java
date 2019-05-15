package com.epam.belote.bonus;
import com.epam.belote.cards.Card;
import com.epam.belote.cards.CardType;

public class Belote implements  Bonus{
    private static int POINTS_FOR_BELOTE = 20;
    private Card firstCard;
    private Card secondCard;

    public Belote(Card firstCard, Card secondCard){
        this.firstCard = firstCard;
        this.secondCard = secondCard;
    }

   @Override
    public int getBonus(){
        if((firstCard.getType().equals(CardType.QUEEN) && secondCard.getType().equals(CardType.KING) ||
            firstCard.getType().equals(CardType.KING) && secondCard.getType().equals(CardType.QUEEN)) &&
                firstCard.getSuit().equals(secondCard.getSuit())) {
            return POINTS_FOR_BELOTE;
        }
        return 0;
   }
}
