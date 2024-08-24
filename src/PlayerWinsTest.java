import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PlayerWinsTest {
    private DrawFrame drawPanel;
    private PlayerWins playerWins;

    @Before
    public void setUp() {
        drawPanel = new DrawFrame();
        playerWins = new PlayerWins();
    }

    @Test
    public void testProcessOutcome_PlayerWins() {
        playerWins.processOutcome(drawPanel, false);

        assertEquals("¡Ganaste!", drawPanel.getMessage());
        assertTrue(!drawPanel.isGameOn());
    }
}
