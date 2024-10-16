import java.util.ArrayList;

public class HangmanGame {
    String safeword;
    String usedCharacters;
    String currentSolution = "";
    char currentChar;
    int wrongGuesses = 0;
    int maxGuesses = 6;

    public HangmanGame(String strSafeword){
        safeword = strSafeword.toUpperCase();
        currentSolution = "";
        usedCharacters = "";
        int i = 0;
        while (i<safeword.length()){
            currentSolution += "_";
            i++;
        }
        currentSolution = currentSolution.trim();
    }

    public void takeAGuess (Character chCurrenChar){
        currentChar = Character.toUpperCase(chCurrenChar);
        usedCharacters += currentChar;
        int i = safeword.indexOf(currentChar);
        if(i==(-1)){
            this.guessWrong(currentChar);
        }
        while ((i<safeword.length()) && (i!=(-1))){
            currentSolution = currentSolution.substring(0,i)
                    +currentChar
                    +currentSolution.substring( i+1);
            i = safeword.indexOf(currentChar,i+1);
        }
        //Sieg
        if (currentSolution.equals(safeword)){
            usedCharacters = "Congratulations, you win!";
        }
    }

    public void guessWrong(char chCurrentChar){
        wrongGuesses++;
        if(wrongGuesses >= maxGuesses){
            usedCharacters = "You lost to: \""+ safeword + "\"";
        }

    }


}
