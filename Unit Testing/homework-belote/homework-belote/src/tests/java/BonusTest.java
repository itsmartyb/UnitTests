import com.epam.belote.CardPlayer;
import com.epam.belote.Player;
import com.epam.belote.Team;
import com.epam.belote.bonus.Belote;
import com.epam.belote.bonus.Bonus;
import com.epam.belote.cards.Card;
import com.epam.belote.cards.CardSuit;
import com.epam.belote.cards.CardType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;


public class BonusTest {
    private Team team;
    private Player firstPlayer;
    private Player secondPlayer;

    @Before
    public void setUp() {
        this.team = new Team();
        this.firstPlayer = new CardPlayer(team);
        this.secondPlayer = new CardPlayer(team);
    }

    @Test
    public void testForSequenceOfThree() {
        this.firstPlayer.addCard(new Card(CardType.JACK, CardSuit.CLUBS));
        this.firstPlayer.addCard(new Card(CardType.KING, CardSuit.CLUBS));
        this.firstPlayer.addCard(new Card(CardType.EIGHT, CardSuit.CLUBS));
        this.firstPlayer.addCard(new Card(CardType.QUEEN, CardSuit.CLUBS));
        Set<Bonus> bonuses = this.firstPlayer.declareBonus();
        team.calculatePoints(bonuses);
        Assert.assertEquals(20, team.getScore());
    }

    @Test
    public void testForSequenceOfFour() {
        this.firstPlayer.addCard(new Card(CardType.JACK, CardSuit.HEARTS));
        this.firstPlayer.addCard(new Card(CardType.KING, CardSuit.HEARTS));
        this.firstPlayer.addCard(new Card(CardType.ACE, CardSuit.HEARTS));
        this.firstPlayer.addCard(new Card(CardType.QUEEN, CardSuit.HEARTS));
        this.firstPlayer.addCard(new Card(CardType.QUEEN, CardSuit.SPADES));
        this.firstPlayer.addCard(new Card(CardType.SEVEN, CardSuit.CLUBS));
        this.firstPlayer.addCard(new Card(CardType.ACE, CardSuit.DIAMONDS));
        Set<Bonus> bonuses = this.firstPlayer.declareBonus();
        team.calculatePoints(bonuses);
        Assert.assertEquals(50, team.getScore());
    }

    @Test
    public void testForSequenceOfFive() {
        this.firstPlayer.addCard(new Card(CardType.SEVEN, CardSuit.DIAMONDS));
        this.firstPlayer.addCard(new Card(CardType.KING, CardSuit.HEARTS));
        this.firstPlayer.addCard(new Card(CardType.EIGHT, CardSuit.DIAMONDS));
        this.firstPlayer.addCard(new Card(CardType.NINE, CardSuit.DIAMONDS));
        this.firstPlayer.addCard(new Card(CardType.QUEEN, CardSuit.SPADES));
        this.firstPlayer.addCard(new Card(CardType.JACK, CardSuit.DIAMONDS));
        this.firstPlayer.addCard(new Card(CardType.TEN, CardSuit.DIAMONDS));
        this.firstPlayer.addCard(new Card(CardType.ACE, CardSuit.CLUBS));
        Set<Bonus> bonuses = this.firstPlayer.declareBonus();
        team.calculatePoints(bonuses);
        Assert.assertEquals(100, team.getScore());
    }

    @Test
    public void testForQuadOfJacks() {
        this.firstPlayer.addCard(new Card(CardType.JACK, CardSuit.SPADES));
        this.firstPlayer.addCard(new Card(CardType.JACK, CardSuit.CLUBS));
        this.firstPlayer.addCard(new Card(CardType.JACK, CardSuit.DIAMONDS));
        this.firstPlayer.addCard(new Card(CardType.JACK, CardSuit.HEARTS));
        Set<Bonus> bonuses = this.firstPlayer.declareBonus();
        team.calculatePoints(bonuses);
        Assert.assertEquals(200, team.getScore());
    }

    @Test
    public void testForQuadOfQueens() {
        this.firstPlayer.addCard(new Card(CardType.QUEEN, CardSuit.SPADES));
        this.firstPlayer.addCard(new Card(CardType.QUEEN, CardSuit.CLUBS));
        this.firstPlayer.addCard(new Card(CardType.QUEEN, CardSuit.DIAMONDS));
        this.firstPlayer.addCard(new Card(CardType.QUEEN, CardSuit.HEARTS));
        this.firstPlayer.addCard(new Card(CardType.ACE, CardSuit.SPADES));
        Set<Bonus> bonuses = this.firstPlayer.declareBonus();
        team.calculatePoints(bonuses);
        Assert.assertEquals(100, team.getScore());
    }

    @Test
    public void testForQuadOfNines() {
        this.firstPlayer.addCard(new Card(CardType.NINE, CardSuit.SPADES));
        this.firstPlayer.addCard(new Card(CardType.NINE, CardSuit.CLUBS));
        this.firstPlayer.addCard(new Card(CardType.NINE, CardSuit.DIAMONDS));
        this.firstPlayer.addCard(new Card(CardType.ACE, CardSuit.HEARTS));
        this.firstPlayer.addCard(new Card(CardType.NINE, CardSuit.HEARTS));
        Set<Bonus> bonuses = this.firstPlayer.declareBonus();
        team.calculatePoints(bonuses);
        Assert.assertEquals(150, team.getScore());
    }

    @Test
    public void testForQuadOfSevens() {
        this.firstPlayer.addCard(new Card(CardType.SEVEN, CardSuit.SPADES));
        this.firstPlayer.addCard(new Card(CardType.SEVEN, CardSuit.CLUBS));
        this.firstPlayer.addCard(new Card(CardType.SEVEN, CardSuit.DIAMONDS));
        this.firstPlayer.addCard(new Card(CardType.SEVEN, CardSuit.HEARTS));
        this.firstPlayer.addCard(new Card(CardType.NINE, CardSuit.HEARTS));
        Set<Bonus> bonuses = this.firstPlayer.declareBonus();
        team.calculatePoints(bonuses);
        Assert.assertEquals(0, team.getScore());
    }

    @Test
    public void testFor2SequencesOf20() {
        this.firstPlayer.addCard(new Card(CardType.NINE, CardSuit.SPADES));
        this.firstPlayer.addCard(new Card(CardType.TEN, CardSuit.SPADES));
        this.firstPlayer.addCard(new Card(CardType.JACK, CardSuit.SPADES));
        this.firstPlayer.addCard(new Card(CardType.SEVEN, CardSuit.CLUBS));
        this.firstPlayer.addCard(new Card(CardType.NINE, CardSuit.HEARTS));
        this.firstPlayer.addCard(new Card(CardType.TEN, CardSuit.HEARTS));
        this.firstPlayer.addCard(new Card(CardType.EIGHT, CardSuit.HEARTS));
        Set<Bonus> bonuses = this.firstPlayer.declareBonus();
        team.calculatePoints(bonuses);
        Assert.assertEquals(40, team.getScore());
    }

    @Test
    public void testForTwoKindOfSequences() {
        this.firstPlayer.addCard(new Card(CardType.NINE, CardSuit.SPADES));
        this.firstPlayer.addCard(new Card(CardType.TEN, CardSuit.SPADES));
        this.firstPlayer.addCard(new Card(CardType.JACK, CardSuit.SPADES));
        this.firstPlayer.addCard(new Card(CardType.ACE, CardSuit.HEARTS));
        this.firstPlayer.addCard(new Card(CardType.JACK, CardSuit.HEARTS));
        this.firstPlayer.addCard(new Card(CardType.KING, CardSuit.HEARTS));
        this.firstPlayer.addCard(new Card(CardType.QUEEN, CardSuit.HEARTS));
        Set<Bonus> bonuses = this.firstPlayer.declareBonus();
        team.calculatePoints(bonuses);
        Assert.assertEquals(90, team.getScore());
    }

    @Test
    public void testWhenBothPlayersHaveBonuses() {
        this.firstPlayer.addCard(new Card(CardType.NINE, CardSuit.SPADES));
        this.firstPlayer.addCard(new Card(CardType.TEN, CardSuit.SPADES));
        this.firstPlayer.addCard(new Card(CardType.JACK, CardSuit.SPADES));
        this.secondPlayer.addCard(new Card(CardType.SEVEN, CardSuit.CLUBS));
        this.secondPlayer.addCard(new Card(CardType.NINE, CardSuit.CLUBS));
        this.secondPlayer.addCard(new Card(CardType.TEN, CardSuit.CLUBS));
        this.secondPlayer.addCard(new Card(CardType.EIGHT, CardSuit.CLUBS));
        Set<Bonus> firstPlayerBonuses = this.firstPlayer.declareBonus();
        Set<Bonus> secondPlayerBonuses = this.secondPlayer.declareBonus();
        team.calculatePoints(firstPlayerBonuses);
        team.calculatePoints(secondPlayerBonuses);
        Assert.assertEquals(70, team.getScore());
    }

    @Test
    public void testForBelote() {
        this.firstPlayer.addCard(new Card(CardType.QUEEN, CardSuit.DIAMONDS));
        this.firstPlayer.addCard(new Card(CardType.TEN, CardSuit.SPADES));
        this.firstPlayer.addCard(new Card(CardType.KING, CardSuit.DIAMONDS));
        Set<Bonus> bonuses = this.firstPlayer.declareBonus();
        team.calculatePoints(bonuses);
        Assert.assertEquals(20, team.getScore());
    }

    @Test
    public void testSequenceAndBelote() {
        this.firstPlayer.addCard(new Card(CardType.QUEEN, CardSuit.DIAMONDS));
        this.firstPlayer.addCard(new Card(CardType.TEN, CardSuit.SPADES));
        this.firstPlayer.addCard(new Card(CardType.KING, CardSuit.DIAMONDS));
        this.firstPlayer.addCard(new Card(CardType.ACE, CardSuit.DIAMONDS));
        Set<Bonus> bonuses = this.firstPlayer.declareBonus();
        team.calculatePoints(bonuses);
        Assert.assertEquals(40, team.getScore());
    }

    @Test
    public void addBeloteBonus() {
        this.firstPlayer.addCard(new Card(CardType.QUEEN, CardSuit.CLUBS));
        this.firstPlayer.addCard(new Card(CardType.KING, CardSuit.CLUBS));
        this.secondPlayer.addCard(new Card(CardType.QUEEN, CardSuit.DIAMONDS));
        this.secondPlayer.addCard(new Card(CardType.KING, CardSuit.DIAMONDS));
        Set<Bonus> firstPlayerBonuses = this.firstPlayer.declareBonus();
        Set<Bonus> secondPlayerBonuses = this.secondPlayer.declareBonus();
        team.calculatePoints(firstPlayerBonuses);
        team.calculatePoints(secondPlayerBonuses);
        Assert.assertEquals(40, team.getScore());
    }
}
