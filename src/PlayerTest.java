import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() {
        player = new Player();
    }

    @Test
    public void testAddCard_SingleAce() {
        Card aceOfSpades = new Card(Card.Suit.SPADES, Card.FaceValue.ACE, null);
        player.addCard(aceOfSpades);

        int[] valueOfHand = player.getValueOfHand();
        assertEquals(11, valueOfHand[0]);
        assertEquals(1, valueOfHand[1]);
    }

    @Test
    public void testAddCard_AceAndFaceCard() {
        Card aceOfSpades = new Card(Card.Suit.SPADES, Card.FaceValue.ACE, null);
        Card kingOfHearts = new Card(Card.Suit.HEARTS, Card.FaceValue.KING, null);
        player.addCard(aceOfSpades);
        player.addCard(kingOfHearts);

        int[] valueOfHand = player.getValueOfHand();
        assertEquals(21, valueOfHand[0]);
        assertEquals(11, valueOfHand[1]);
    }

    @Test
    public void testAddCard_TwoNonAceCards() {
        Card fiveOfDiamonds = new Card(Card.Suit.DIAMONDS, Card.FaceValue.FIVE, null);
        Card sixOfClubs = new Card(Card.Suit.CLUBS, Card.FaceValue.SIX, null);
        player.addCard(fiveOfDiamonds);
        player.addCard(sixOfClubs);

        int[] valueOfHand = player.getValueOfHand();
        assertEquals(11, valueOfHand[0]);
        assertEquals(11, valueOfHand[1]);
    }

    @Test
    public void testAddCard_TwoAces() {
        Card aceOfSpades = new Card(Card.Suit.SPADES, Card.FaceValue.ACE, null);
        Card aceOfHearts = new Card(Card.Suit.HEARTS, Card.FaceValue.ACE, null);
        player.addCard(aceOfSpades);
        player.addCard(aceOfHearts);

        int[] valueOfHand = player.getValueOfHand();
        assertEquals(12, valueOfHand[0]); 
        assertEquals(2, valueOfHand[1]); 
    }

    @Test
    public void testGetHand() {
        Card aceOfSpades = new Card(Card.Suit.SPADES, Card.FaceValue.ACE, null);
        player.addCard(aceOfSpades);

        ArrayList<Card> hand = player.getHand();
        assertEquals(1, hand.size());
        assertEquals(aceOfSpades, hand.get(0));
    }

    @Test
    public void testToString() {
        Card tenOfHearts = new Card(Card.Suit.HEARTS, Card.FaceValue.TEN, null);
        Card kingOfDiamonds = new Card(Card.Suit.DIAMONDS, Card.FaceValue.KING, null);
        player.addCard(tenOfHearts);
        player.addCard(kingOfDiamonds);

        String handString = player.toString();
        assertTrue(handString.contains("TEN of HEARTS"));
        assertTrue(handString.contains("KING of DIAMONDS"));
    }
}
