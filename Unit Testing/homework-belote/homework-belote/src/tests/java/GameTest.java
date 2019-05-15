import com.epam.belote.*;
import com.epam.belote.cards.Card;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.Arrays;


public class GameTest {

    @Test
    public void dealCardsWhenTrump() {
        CardPlayer player = Mockito.mock(CardPlayer.class);
        Mockito.when(player.bid()).thenReturn(Bid.ALL_TRUMPS);
        Game game = new Game(Arrays.asList(player));
        game.dealCards();
        Assert.assertEquals(24,game.getCardDealer().getDeck().getDeckSize());
    }


}
