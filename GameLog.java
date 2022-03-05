/**
 * Project 3 -- Battleship
 *
 * Create a program in a class called PlayGame.java that reads data
 * from two files ShipPositionsPlayerOne.txt
 * and ShipPositionsPlayerTwo.txt
 * and plays the board game Battleship. A log will
 * be printed with the results.
 * A class called GameLog.java will also be created
 * to help print the log of the results.
 *
 * @author Advit Bhullar, L-24
 *
 * @version October 20, 2021
 *
 */
public class GameLog {
    private int winningPlayer;
    private int losingPlayerHits;
    private int numTurns;
    private String boardPatternOne;
    private String boardPatternTwo;

    public GameLog(int winningPlayer, int losingPlayerHits,
                   int numTurns, String boardPatternOne, String boardPatternTwo) {
        this.winningPlayer = winningPlayer;
        this.losingPlayerHits = losingPlayerHits;
        this.numTurns = numTurns;
        this.boardPatternOne = boardPatternOne;
        this.boardPatternTwo = boardPatternTwo;
    }

    public void setBoardPatternTwo(String boardPatternTwo) {
        this.boardPatternTwo = boardPatternTwo;
    }

    @Override
    public String toString() {
        if (winningPlayer == 2)
            return "Battleship Game Log:\n" +
                "Winning Player: Player " + winningPlayer + "\n" +
                "Hits: " + losingPlayerHits + " - 17" + "\n" +
                "Number of Turns To Win: " + numTurns + "\n" +
                "Player 1 Board Pattern: " + boardPatternOne + "\n" +
                "Player 2 Board Pattern: " + boardPatternTwo + "\n" ;
        else
            return "Battleship Game Log:\n" +
                    "Winning Player: Player " + winningPlayer + "\n" +
                    "Hits: " + "17 - " + losingPlayerHits +  "\n" +
                    "Number of Turns To Win: " + numTurns + "\n" +
                    "Player 1 Board Pattern: " + boardPatternOne + "\n" +
                    "Player 2 Board Pattern: " + boardPatternTwo + "\n" ;
    }

}

