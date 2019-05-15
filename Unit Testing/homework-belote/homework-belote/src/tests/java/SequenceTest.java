import com.epam.belote.bonus.Sequence;
import com.epam.belote.cards.CardType;
import org.junit.Test;

import java.util.Arrays;

public class SequenceTest {
    private Sequence sequence;

    @Test(expected = UnsupportedOperationException.class)
    public void throwsWhenUnder3Cards() {
        this.sequence = new Sequence(Arrays.asList(CardType.SEVEN, CardType.EIGHT));
        this.sequence.getBonus();
    }
}
