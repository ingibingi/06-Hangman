import java.util.ArrayList;

public class GameLogic {
    String safeword;
    ArrayList<Character> usedCharacters;
    String currentSolution;
    char currentChar;
    int wrongGuesses = 0;
    int maxGuesses = 6;

    public GameLogic(String strSafeword){
        safeword = strSafeword.toUpperCase();
        int i = 0;
        while (i<safeword.length()){
            currentSolution += "_";
        }
        currentSolution = currentSolution.trim();
    }

    public void takeAGuess (Character chCurrenChar){
        currentChar = Character.toUpperCase(chCurrenChar);
        int i = safeword.indexOf(currentChar);
        if(i==(-1)){
            wrongGuesses++;
            //ToDo: methode für Fehler
        }
        while ((i<safeword.length()) && (i!=(-1))){
            currentSolution = currentSolution.substring(0,i)
                    +currentChar
                    +currentSolution.substring( i+1);
        }
        if (currentSolution.equals(safeword)){
            //ToDo: methode für Sieg
        }

    }


}
