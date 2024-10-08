---
Autor: Ingo Schlapschy
Ort: LBS Eibiswald
Gruppe: 24/25 LG1 2aAPC INFv JRZ
Datum: 2024-10-01
AbgabeErledigt: false
---
# Angabe
- [Link zur Angabe](https://www.eduvidual.at/mod/assign/view.php?id=6290140)
- Deadline: 2024-10-12
```
       1. Lernziele
    • Hangman Algorithmus erstellen
    • Klassenstruktur planen
    • Umsetzung in JAVA mit Swing Klasse (GUI)

    2. Aufgabenstellung
    • Teil 1
        ◦ Welche Klassen werden benötigt?
        ◦ Wie erfolgt die Ausgabe des Status?
            ▪ Es reicht die Anzahl der Versuche zu zählen von 0 bis 9 Fehler 
            ▪ Danach „Game Over“
        ◦ Eingabe von Buchstaben in Textfeld
        ◦ Ausgabe des Lösungswortes mit _ als versteckte Buchstaben
        ◦ History der Buchstaben ausgeben
        ◦ Wenn gelöst: Neu Start ermöglichen
        ◦ Liste der Wörter: statisch im Array
        ◦ Grafische Ausgabe mit 9 Bildern – je Fehlversuch wird ein Bild in ein Panel geladen (einfach die Fehlversuche mitzählen und begrenzen – siehe Eduvidual)
    • Teil 2:
        ◦ Anzahl der Versuche sollte im Menü einstellbar sein. (JMenu)
        ◦ Wörter dynamisch aus Datei lesen (mittels File & Scanner Klasse)
        ◦ History der Buchstaben ausgeben sollte als es als Option im Menü geben (JCheckBoxMenuItem)

```
## Zusammengefasst
## Ziele
- Hangman-Spiel-GUI erstellen
- Hangman-Spiel-Logik schreiben
## ToDo
- Spiellogik schreiben

# Protokoll
## Klasse für Spiellogik erstellen
### Konstruktor
- Ein neues Spiel braucht das gesuchte Wort "safeword"
- Der aktuelle Fortschritt soll auch erstellt werden. 
  - Dabei wird jeder Buchstabe des safewords durch '_' ersetzt.
```java
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
```
### Methode: Hauptspielzug: einen Buchstaben raten
- Der Buchstabe soll zur Liste der verwendeten Buchstaben hinzugefügt werden
- Ein falscher Buchstabe soll als solcher erfasst werden
- Ein richtiger Buchstabe soll an allen Plätzen in der Lösung eingefügt werden
- Überprüfung ob man das Spiel gewonnen hat
```java
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

```
- 