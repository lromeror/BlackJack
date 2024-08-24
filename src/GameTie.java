import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;

public class GameTie implements GameOutcome {
    @Override
    public void processOutcome(DrawFrame drawPanel, boolean gameOn) {
        String message = "Tie !";
        drawPanel.setMessage(message);
        drawPanel.setGameOn(gameOn);
    }
}
