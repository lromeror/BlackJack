/*
 * Utility class, includes methods to decide the winner
 */
public class Utility {

    // Blackjack value
    static final int BLACK_JACK = 21;

    // Who is the winner
    public enum Winner {PLAYER, DEALER, TIE}

    /*
     * Determine winner by selecting the biggest hand from player's and dealer's hands.
     * Four hands altogether (player: ace=1, ace=11) (dealer: ace=1, ace=11)
     */
    public Winner determineWinner(Player player, Player dealer) {
        int biggestPlayerHand = getBiggestHandUnder21(player);
        int biggestDealerHand = getBiggestHandUnder21(dealer);

        // Determine the winner
        if (biggestPlayerHand == biggestDealerHand) {
            return Winner.TIE;
        } else if (biggestPlayerHand > biggestDealerHand) {
            return Winner.PLAYER;
        } else {
            return Winner.DEALER;
        }
    }

    /*
     * Get the biggest hand value under 21 or closest to 21 for a player
     */
    private int getBiggestHandUnder21(Player player) {
        int[] handValues = player.getValueOfHand();
        int handValue1 = handValues[0];
        int handValue2 = handValues[1];

        // Find the biggest of the player's hands under 21
        if (handValue1 > BLACK_JACK) {
            return handValue2;
        } else if (handValue2 > BLACK_JACK) {
            return handValue1;
        } else {
            return Math.max(handValue1, handValue2);
        }
    }

    /*
     * Check if the player has a blackjack.
     * This is checked after the first two cards are dealt
     */
    public boolean checkBlackJack(Player player) {
        int[] handValues = player.getValueOfHand();
        return (handValues[0] == BLACK_JACK || handValues[1] == BLACK_JACK);
    }

    /*
     * Check if player bust (over 21)
     * This is checked after hit button event
     */
    public boolean checkBust(Player player) {
        int[] handValues = player.getValueOfHand();
        return (handValues[0] > BLACK_JACK && handValues[1] > BLACK_JACK);
    }

}
