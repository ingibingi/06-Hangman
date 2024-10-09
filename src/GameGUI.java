import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI {
    private JTextField txtSafeword;
    private JPanel panel1;
    private JTextField txtCurrentSolution;
    private JTextField txtUsedCharacters;
    private JTextField txtInput;
    private JButton btnTakeAGuess;
    private JButton btnNewGame;
    private HangmanGame myGame;

    public GameGUI() {
        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String safeword = txtSafeword.getText();
                myGame = new HangmanGame(safeword);
                txtCurrentSolution.setText(myGame.currentSolution);
            }
        });
        btnTakeAGuess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String userInput = txtInput.getText();
                char currentChar = userInput.charAt(0);

                myGame.takeAGuess(currentChar);
                txtCurrentSolution.setText(myGame.currentSolution);
                txtUsedCharacters.setText(myGame.usedCharacters);
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hangman");
        frame.setContentPane(new GameGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}