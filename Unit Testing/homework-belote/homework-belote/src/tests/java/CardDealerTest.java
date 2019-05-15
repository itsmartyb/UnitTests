import com.epam.belote.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CardDealerTest {
    private CardDealer cardDealer;

    @Before
    public void setUp() {
        this.cardDealer = new BeloteCardDealer();
    }

    @Test
    public void testDealing5Cards() {
        int size = this.cardDealer.getDeck().getDeckSize();
        this.cardDealer.deal5Cards(new CardPlayer(new Team()));
        Assert.assertEquals(size, this.cardDealer.getDeck().getDeckSize() + 5);
    }

    @Test
    public void testDealing3Cards() {
        int size = this.cardDealer.getDeck().getDeckSize();
        this.cardDealer.deal3Cards(new CardPlayer(new Team()));
        Assert.assertEquals(size, this.cardDealer.getDeck().getDeckSize() + 3);
    }
}
