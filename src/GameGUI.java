import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static java.awt.AWTEventMulticaster.add;

public class GameGUI {
    private JTextField txtSafeword;
    private JPanel pnlGameplay;
    private JTextField txtCurrentSolution;
    private JTextField txtUsedCharacters;
    private JTextField txtInput;
    private JButton btnTakeAGuess;
    private JButton btnNewGame;
    private JLabel lblImageArea;
    private HangmanGame myGame;

    public GameGUI() {

        ImageIcon drawing = GameGUI.currentImage(0);
        lblImageArea.setIcon(drawing);

        //New Game
        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String safeword = txtSafeword.getText();
                myGame = new HangmanGame(safeword);
                txtCurrentSolution.setText(myGame.currentSolution);
            }
        });

        //Take a Guess
        btnTakeAGuess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String userInput = txtInput.getText();
                char currentChar = userInput.charAt(0);

                myGame.takeAGuess(currentChar);
                txtCurrentSolution.setText(myGame.currentSolution);
                txtUsedCharacters.setText(myGame.usedCharacters);
                txtInput.setText("");
                txtInput.grabFocus();
            }
        });
    }

    public static ImageIcon currentImage(int ImageNr){
        String imagePath = "files/L"+ImageNr+".jpg";
        ImageIcon myImageIcon = new ImageIcon(imagePath);
        Image myImage = myImageIcon.getImage();
        Image myScaledImage = myImage.getScaledInstance(250,250, Image.SCALE_SMOOTH);
        ImageIcon myScaledImageIcon = new ImageIcon(myScaledImage);

        return myScaledImageIcon;
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Hangman");
        frame.setContentPane(new GameGUI().pnlGameplay);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
    }
}