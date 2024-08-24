import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DealerWinsTest {
    private DrawFrame drawPanel;
    private DealerWins dealerWins;

    @Before
    public void setUp() {
        drawPanel = new DrawFrame();
        dealerWins = new DealerWins();
    }

    @Test
    public void testProcessOutcome_DealerWins() {
        dealerWins.processOutcome(drawPanel, false);

        assertEquals("¡Perdiste!", drawPanel.getMessage());
        assertTrue(!drawPanel.isGameOn());
    }
}
