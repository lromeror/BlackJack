import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GameTieTest {
    private DrawFrame drawPanel;
    private GameTie gameTie;

    @Before
    public void setUp() {
        drawPanel = new DrawFrame();
        gameTie = new GameTie();
    }

    @Test
    public void testProcessOutcome_GameTie() {
        gameTie.processOutcome(drawPanel, false);

        assertEquals("¡Empate!", drawPanel.getMessage());
        assertTrue(!drawPanel.isGameOn());
    }
}
