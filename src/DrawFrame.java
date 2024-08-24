import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class DrawFrame extends JPanel {

    private ArrayList<Card> playerHand;
    private ArrayList<Card> dealerHand;
    String message = "";
    boolean gameOn;

    public void setPlayerHand(ArrayList<Card> playerHand) {
        this.playerHand = playerHand;
    }

    public void setDealerHand(ArrayList<Card> dealerHand) {
        this.dealerHand = dealerHand;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setGameOn(boolean gameOn) {
        this.gameOn = gameOn;
    }

    public void paintComponent(Graphics g) {
        g.setColor(new Color(0.0f, 0.5f, 0.0f));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(new Color(1.0f, 0.0f, 0.0f));
        g.drawString(message, 240, 225);
        if (playerHand != null) {
            for (int i = 0; i < playerHand.size(); i++) {
                Image image = playerHand.get(i).getImage();
                g.drawImage(image, (240 + i * 20), (285), this);
            }
        }
        if (dealerHand != null) {
            for (int i = 0; i < dealerHand.size(); i++) {
                Image image;
                if (gameOn) {
                    if (i == 0) {
                        image = new ImageIcon("pictures/b1fv.png").getImage();
                    } else {
                        image = dealerHand.get(i).getImage();
                    }
                } else {
                    image = dealerHand.get(i).getImage();
                }
                g.drawImage(image, (240 + i * 20), (50), this);
            }
        }
    }
}
