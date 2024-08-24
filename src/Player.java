import java.util.ArrayList;

/*
 * player class
 */
public class Player {
    
    //player's hand
    private ArrayList<Card> hand = new ArrayList<Card>();
    //valueOfHand[0] includes the value with ace valued as 11
    //valueOfHand[1] includes the value with ace valued as 1
    private int[] valueOfHand;
    
    public Player() {
        valueOfHand = new int[2];
    }
    
    /*
     * add card to hand and increase the value of the hand
     */
    public void addCard(Card card) {
        getHand().add(card);
        updateHandValue(card); // Reemplaza el código repetitivo con una llamada al método
    }

    /*
     * Calcula y actualiza el valor de la mano basado en la carta proporcionada
     */
    private void updateHandValue(Card card) {
        boolean aceFound = handContainsAce();

        if (card.getFaceValue() == Card.FaceValue.ACE) {
            if (aceFound) {
                valueOfHand[0] += 1;
            } else {
                valueOfHand[0] += 11;
            }
            valueOfHand[1] += 1;
        } else {
            int cardValue = card.getFaceValue().getIntValue();
            valueOfHand[0] += cardValue;
            valueOfHand[1] += cardValue;
        }
    }

    /*
     * Método de ayuda para verificar si la mano contiene un As
     */
    private boolean handContainsAce() {
        for (Card card : hand) {
            if (card.getFaceValue() == Card.FaceValue.ACE) {
                return true;
            }
        }
        return false;
    }
    
    /*
     * get hand
     */
    public ArrayList<Card> getHand() {
        return hand;
    }
    
    /*
     * get the value of the hand
     */
    public int[] getValueOfHand () {
        return valueOfHand;
    }
    
    /*
     * set the value of the hand
     */
    public void setValueOfHand (int[] valueOfHand) {
        this.valueOfHand = valueOfHand;
    }
    
    /*
     * print hand as a string 
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i < this.hand.size(); i++) {
            sb.append(hand.get(i).getFaceValue().toString() + " of " + hand.get(i).getSuit().toString() + " ");
        }
        return sb.toString();
    }
    
}
