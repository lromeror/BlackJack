import java.awt.Image;

public class Card {

    public enum Suit {CLUBS, SPADES, HEARTS, DIAMONDS}

    public enum FaceValue {
        ACE(1), KING(10), QUEEN(10), JACK(10), TEN(10), NINE(9),
        EIGHT(8), SEVEN(7), SIX(6), FIVE(5), FOUR(4), THREE(3), TWO(2);
        private int intValue;

        FaceValue(int intValue) {
            this.intValue = intValue;
        }

        public int getIntValue() {
            return this.intValue;
        }
    }

    private Suit suit;
    private FaceValue faceValue;
    private Image image;

    public Card(Suit suit, FaceValue faceValue, Image image) {
        this.suit = suit;
        this.faceValue = faceValue;
        this.image = image;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public FaceValue getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(FaceValue faceValue) {
        this.faceValue = faceValue;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
