import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BlackJackGui {

    static final int DEALER_LIMIT = 17;

    private JFrame frame;
    private Deck deck;
    private DrawFrame drawPanel;
    private Player player;
    private Player dealer;
    private String message = "";
    private Utility help;
    private boolean gameOn;

    public static void main(String[] args) {
        BlackJackGui gui = new BlackJackGui();
        gui.init();
    }

    public void init() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawPanel = new DrawFrame();
        drawPanel.setBounds(0, 0, 600, 500);
        drawPanel.setLayout(null);

        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(drawPanel);
        frame.setSize(600, 500);
        frame.setVisible(true);

        JButton newGameButton = new JButton("NEW GAME");
        newGameButton.setBounds(145, 415, 100, 35);
        drawPanel.add(newGameButton);

        JButton hitButton = new JButton("HIT");
        hitButton.setBounds(270, 415, 60, 35);
        drawPanel.add(hitButton);

        JButton standButton = new JButton("STAND");
        standButton.setBounds(355, 415, 75, 35);
        drawPanel.add(standButton);

        hitButton.addActionListener(new HitListener());
        newGameButton.addActionListener(new NewGameListener());
        standButton.addActionListener(new StandListener());
    }

    private void setupNewGame() {
        deck = new Deck();
        player = new Player();
        dealer = new Player();
        help = new Utility();
        message = "";
        gameOn = true;
    }

    private void updateUI() {
        drawPanel.setPlayerHand(player.getHand());
        drawPanel.setDealerHand(dealer.getHand());
        drawPanel.setMessage(message);
        drawPanel.setGameOn(gameOn);
        frame.repaint();
    }

    class NewGameListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (!gameOn) {
                setupNewGame();
                for (int i = 0; i < 2; i++) {
                    dealer.addCard(deck.dealCard());
                    player.addCard(deck.dealCard());
                }
                if (help.checkBlackJack(player)) {
                    if (help.determineWinner(player, dealer) == Utility.Winner.TIE) {
                        message = "Blackjack ! Tie !";
                        gameOn = false;
                    } else {
                        message = "Blackjack ! You win !";
                        gameOn = false;
                    }
                }
                updateUI();
            }
        }
    }

    class HitListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (gameOn) {
                player.addCard(deck.dealCard());
                if (help.checkBust(player)) {
                    message = "Busted ! You lose !";
                    gameOn = false;
                }
                updateUI();
            }
        }
    }

    class StandListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (gameOn) {
                gameOn = false;
                while ((dealer.getValueOfHand()[0] < DEALER_LIMIT) && (dealer.getValueOfHand()[1] < DEALER_LIMIT)) {
                    dealer.addCard(deck.dealCard());
                }
                GameOutcome outcome;
                if (help.checkBust(dealer)) {
                    outcome = new PlayerWins();
                } else {
                    Utility.Winner winner = help.determineWinner(player, dealer);
                    if (winner == Utility.Winner.PLAYER) {
                        outcome = new PlayerWins();
                    } else if (winner == Utility.Winner.DEALER) {
                        outcome = new DealerWins();
                    } else {
                        outcome = new GameTie();
                    }
                }
                outcome.processOutcome(drawPanel, gameOn);
                frame.repaint();
            }
        }
    }
}
