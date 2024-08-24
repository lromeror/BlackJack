import javax.swing.JPanel;


public class PlayerWins implements GameOutcome {
    @Override
    public void processOutcome(DrawFrame drawPanel, boolean gameOn) {
        String message = "You win !";
        drawPanel.setMessage(message);
        drawPanel.setGameOn(gameOn);
    }
}
