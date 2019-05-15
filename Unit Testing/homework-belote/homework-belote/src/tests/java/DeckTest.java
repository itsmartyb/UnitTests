import com.epam.belote.CardPlayer;
import com.epam.belote.Player;
import com.epam.belote.Team;
import com.epam.belote.cards.Card;
import com.epam.belote.cards.CardSuit;
import com.epam.belote.cards.CardType;
import com.epam.belote.cards.Deck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeckTest {
    private Deck deck;
    private Team team;
    private Player player;


    @Before
    public void setUp() {
        this.deck = new Deck();
        this.team = new Team();
        this.player = new CardPlayer(team);
    }

    @Test
    public void testGetCardByIndex() {
        Assert.assertTrue(this.deck.getCard(14).equals(new Card(CardType.TEN, CardSuit.HEARTS)));
    }

    @Test
    public void testRemoveFirstCardFromDeck() {
        Card deckCard = this.deck.getFirstCard();
        Card card = new Card(CardType.SEVEN, CardSuit.CLUBS);
        Assert.assertEquals(deckCard, card);
    }

    @Test
    public void testEqualCardUnderTheTenthCardWhenCuttingDeck() {
        Deck testDeck = new Deck();
        this.deck.cut();
        Assert.assertEquals(testDeck.getCard(15), this.deck.getCard(5));

    }

    @Test
    public void testEqualCardOverTheTenthCardWhenCuttingDeck() {
        Deck testDeck = new Deck();
        this.deck.cut();
        Assert.assertEquals(testDeck.getCard(5), this.deck.getCard(27));
    }

    @Test
    public void testEqualCardExactlyTheTenthCard() {
        Deck testDeck = new Deck();
        this.deck.cut();
        Assert.assertEquals(testDeck.getCard(9), this.deck.getCard(31));
    }


}
