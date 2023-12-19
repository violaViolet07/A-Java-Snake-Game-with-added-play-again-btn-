import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

public class GameFrame extends JFrame implements ActionListener {
    GamePanel game;
    JButton resetButton;
    JButton playButton;

    GameFrame() {
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLayout(null); // Use null layout for manual component positioning

        // Create and configure the game panel (but hide it initially)
        game = new GamePanel();
        game.setBounds(0, 0, GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT);
        game.setVisible(false);
        this.add(game);

        // Create and configure the reset button (but hide it initially)
        resetButton = new JButton("Play Again");
        resetButton.setSize(100, 50);
        resetButton.setLocation((GamePanel.SCREEN_WIDTH - resetButton.getWidth()) / 2, GamePanel.SCREEN_HEIGHT / 2 + 50); // Position the button below the "Game Over" text
        resetButton.addActionListener(this);
        resetButton.setVisible(false);
        this.add(resetButton);

        // Create and configure the play button
        playButton = new JButton("Play");
        playButton.setSize(100, 50);
        playButton.setLocation((GamePanel.SCREEN_WIDTH - playButton.getWidth()) / 2, GamePanel.SCREEN_HEIGHT / 2); // Position the button in the center of the screen
        playButton.addActionListener(this);
        this.add(playButton);

        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            game.reset(); // Call the reset method of the game panel
            resetButton.setVisible(false); // Hide the "Play Again" button after resetting the game
            playButton.setVisible(true); // Show the "Play" button again
        } else if (e.getSource() == playButton) {
            game.setVisible(true); // Show the game panel when the "Play" button is clicked
            playButton.setVisible(false); // Hide the "Play" button
            game.startGame(); // Start the game
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GameFrame();
            }
        });
    }
}
