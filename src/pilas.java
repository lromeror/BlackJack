import javax.swing.JPanel;

// Clase concreta que maneja el caso de empate en el juego
public class GameTie implements GameOutcome {
    @Override
    public void processOutcome(DrawFrame drawPanel, boolean gameOn) {
        String message = "¡Empate!";
        drawPanel.setMessage(message);
        drawPanel.setGameOn(gameOn);
    }
}
