import com.epam.belote.*;
import com.epam.belote.cards.Card;
import com.epam.belote.cards.CardSuit;
import com.epam.belote.cards.CardType;
import com.epam.belote.cards.Deck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
    private CardPlayer player;
    private CardDealer cardDealer;

    public PlayerTest() {
    }

    @Before
    public void setUp() {
        this.player = new CardPlayer(new Team());
        this.cardDealer = new BeloteCardDealer();
    }

    @Test
    public void testForReceivingCardsFromDeck() {
        for(int i = 0; i < 8; i++) {
            this.player.addCard(this.cardDealer.getDeck().getFirstCard());
        }
        Assert.assertTrue(this.player.getHandSize() == 8 && this.cardDealer.getDeck().getDeckSize() == 24);
    }

    @Test
    public void testReturningTheCardsBackToDeck() {
        for(int i = 0; i < 8; i++) {
            this.player.addCard(this.cardDealer.getDeck().getFirstCard());
        }
        this.player.throwCards(this.cardDealer.getDeck());
        Assert.assertTrue(this.player.getHandSize() == 0 && this.cardDealer.getDeck().getDeckSize() == 32);
    }

    @Test
    public void testPlayingCard() {
        this.player.addCard(new Card(CardType.ACE, CardSuit.HEARTS));
        this.player.addCard(new Card(CardType.EIGHT, CardSuit.CLUBS));
        this.player.playCard();
        Assert.assertTrue(this.player.getHandSize() == 1);
    }
}
