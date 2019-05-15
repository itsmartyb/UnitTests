import com.epam.belote.bonus.Belote;
import com.epam.belote.cards.Card;
import com.epam.belote.cards.CardSuit;
import com.epam.belote.cards.CardType;
import org.junit.Assert;
import org.junit.Test;

public class BeloteTest {
    private Card firstCard;
    private Card secondCard;

    @Test
    public void testForHavingBelote() {
        this.firstCard = new Card(CardType.QUEEN, CardSuit.CLUBS);
        this.secondCard = new Card(CardType.KING, CardSuit.CLUBS);
        Belote belote = new Belote(firstCard, secondCard);
        Assert.assertEquals(20,belote.getBonus());
    }

    @Test
    public void testForHavingBeloteFromDifferentSuits() {
        this.firstCard = new Card(CardType.QUEEN, CardSuit.HEARTS);
        this.secondCard = new Card(CardType.KING, CardSuit.CLUBS);
        Belote belote = new Belote(firstCard, secondCard);
        Assert.assertEquals(0,belote.getBonus());
    }

    @Test
    public void testForHaving2DifferentCards() {
        this.firstCard = new Card(CardType.QUEEN, CardSuit.HEARTS);
        this.secondCard = new Card(CardType.JACK, CardSuit.CLUBS);
        Belote belote = new Belote(firstCard, secondCard);
        Assert.assertEquals(0,belote.getBonus());
    }


}
