import com.epam.belote.bonus.Quad;
import com.epam.belote.cards.CardType;
import org.junit.Assert;
import org.junit.Test;

public class QuadTest {
    private Quad quad;

    @Test
    public void testQuadBonusForJacks() {
        this.quad = new Quad(CardType.JACK);
        Assert.assertTrue(quad.getBonus() == 200);
    }

    @Test
    public void testQuadBonusForKings() {
        this.quad = new Quad(CardType.KING);
        Assert.assertTrue(quad.getBonus() == 100);
    }

    @Test
    public void testQuadBonusForNines() {
        this.quad = new Quad(CardType.NINE);
        Assert.assertTrue(quad.getBonus() == 150);
    }

    @Test
    public void testQuadBonusForEights() {
        this.quad = new Quad(CardType.EIGHT);
        Assert.assertTrue(quad.getBonus() == 0);
    }

}
