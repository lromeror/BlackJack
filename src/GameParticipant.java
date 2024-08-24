
import java.util.ArrayList;

public interface GameParticipant {
    void addCard(Card card);
    ArrayList<Card> getHand();
    int[] getValueOfHand();
}
