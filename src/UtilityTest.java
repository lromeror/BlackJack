import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtilityTest {

    private Utility utility;
    private Player player;
    private Player dealer;

    @Before
    public void setUp() {
        utility = new Utility();
        player = new Player();
        dealer = new Player();
    }

    @Test
    public void testDetermineWinner_PlayerWins() {
        player.addCard(new Card(Card.Suit.HEARTS, Card.FaceValue.TEN, null));
        player.addCard(new Card(Card.Suit.SPADES, Card.FaceValue.ACE, null));
        
        dealer.addCard(new Card(Card.Suit.CLUBS, Card.FaceValue.TEN, null));
        dealer.addCard(new Card(Card.Suit.DIAMONDS, Card.FaceValue.NINE, null));
        
        Utility.Winner winner = utility.determineWinner(player, dealer);
        assertEquals(Utility.Winner.PLAYER, winner);
    }

    @Test
    public void testDetermineWinner_DealerWins() {
        player.addCard(new Card(Card.Suit.HEARTS, Card.FaceValue.SIX, null));
        player.addCard(new Card(Card.Suit.SPADES, Card.FaceValue.FIVE, null));
        
        dealer.addCard(new Card(Card.Suit.CLUBS, Card.FaceValue.QUEEN, null));
        dealer.addCard(new Card(Card.Suit.DIAMONDS, Card.FaceValue.TEN, null));
        
        Utility.Winner winner = utility.determineWinner(player, dealer);
        assertEquals(Utility.Winner.DEALER, winner);
    }

    @Test
    public void testDetermineWinner_Tie() {
        player.addCard(new Card(Card.Suit.HEARTS, Card.FaceValue.QUEEN, null));
        player.addCard(new Card(Card.Suit.SPADES, Card.FaceValue.NINE, null));
        
        dealer.addCard(new Card(Card.Suit.CLUBS, Card.FaceValue.TEN, null));
        dealer.addCard(new Card(Card.Suit.DIAMONDS, Card.FaceValue.NINE, null));
        
        Utility.Winner winner = utility.determineWinner(player, dealer);
        assertEquals(Utility.Winner.TIE, winner);
    }

    @Test
    public void testCheckBlackJack_PlayerHasBlackJack() {
        player.addCard(new Card(Card.Suit.HEARTS, Card.FaceValue.TEN, null));
        player.addCard(new Card(Card.Suit.SPADES, Card.FaceValue.ACE, null));
        
        assertTrue(utility.checkBlackJack(player));
    }

    @Test
    public void testCheckBlackJack_PlayerDoesNotHaveBlackJack() {
        player.addCard(new Card(Card.Suit.HEARTS, Card.FaceValue.NINE, null));
        player.addCard(new Card(Card.Suit.SPADES, Card.FaceValue.TWO, null));
        
        assertFalse(utility.checkBlackJack(player));
    }

    @Test
    public void testCheckBust_PlayerBusted() {
        player.addCard(new Card(Card.Suit.HEARTS, Card.FaceValue.TEN, null));
        player.addCard(new Card(Card.Suit.SPADES, Card.FaceValue.KING, null));
        player.addCard(new Card(Card.Suit.DIAMONDS, Card.FaceValue.THREE, null));
        
        assertTrue(utility.checkBust(player));
    }

    @Test
    public void testCheckBust_PlayerNotBusted() {
        player.addCard(new Card(Card.Suit.HEARTS, Card.FaceValue.SEVEN, null));
        player.addCard(new Card(Card.Suit.SPADES, Card.FaceValue.THREE, null));
        
        assertFalse(utility.checkBust(player));
    }
}
