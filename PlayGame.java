import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
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
public class PlayGame {
    public static void main(String[] args) throws FileNotFoundException {
        File f1 = new File("ShipPositionsPlayerOne.txt");
        FileReader fr1 = new FileReader(f1);
        BufferedReader bfr1 = new BufferedReader(fr1);
        String[] shipPositionsPlayerOne = new String[10];
        try {
            for (int i = 0; i < 10 ; i++) {
                shipPositionsPlayerOne[i] = bfr1.readLine() ;
            }
            bfr1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File f2 = new File("ShipPositionsPlayerTwo.txt");
        FileReader fr2 = new FileReader(f2);
        BufferedReader bfr2 = new BufferedReader(fr2);
        String[] shipPositionsPlayerTwo = new String[10];
        try {
            for (int i = 0; i < 10 ; i++) {
                shipPositionsPlayerTwo[i] = bfr2.readLine() ;
            }
            bfr2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Hello, Welcome to Battleship!");
        Scanner scan = new Scanner(System.in);
        int player1Hits = 0;
        int player1Turns = 0;
        int player2Hits = 0;
        int player2Turns = 0;
        int player1Top = 0;
        int player1Middle = 0;
        int player1Bottom = 0;
        int player2Top = 0;
        int player2Middle = 0;
        int player2Bottom = 0;
        int winningPlayer = 0;
        int losingPlayerHits = 0;
        int numTurns = 0;
        String player1;
        String player2;
        ArrayList<String> s1 = new ArrayList<>();
        ArrayList<String> s2 = new ArrayList<>();
        char player1Row = ' ';
        int player1Column = 0;
        char player2Row = ' ';
        int player2Column = 0;

        while (player1Hits < 17 && player2Hits < 17) {
            System.out.println("Player 1 - Enter a row letter from A - J");
            if (scan.hasNextLine())
                player1Row = scan.nextLine().charAt(0);
            System.out.println("Player 1 - Enter a column number from 1 - 14");
            if (scan.hasNextLine())
                player1Column = Integer.parseInt(scan.nextLine());
            player1 = String.valueOf(player1Row) + player1Column;
            if (String.valueOf(shipPositionsPlayerTwo[player1Row - 65].charAt(player1Column - 1))
                    .equals("H") && !s1.contains(player1)) {
                System.out.println("Value:H");
                player1Hits++;
                s1.add(player1);
            } else
                System.out.println("Value:M");
            player1Turns++;
            if (player1Hits < 17 && player2Hits < 17) {


                System.out.println("Player 2 - Enter a row letter from A - J");
                if (scan.hasNextLine())
                    player2Row = scan.nextLine().charAt(0);
                System.out.println("Player 2 - Enter a column number from 1 - 14");
                if (scan.hasNextLine())
                    player2Column = Integer.parseInt(scan.nextLine());
                player2 = String.valueOf(player2Row) + player2Column;
                if (String.valueOf(shipPositionsPlayerOne[player2Row - 65].charAt(player2Column - 1))
                        .equals("H") && !s2.contains(player2)) {
                    System.out.println("Value:H");
                    player2Hits++;
                    s2.add(player2);
                } else
                    System.out.println("Value:M");
                player2Turns++;
            }
        }

        if (player1Hits == 17 ) {
            System.out.println("Enemy fleet destroyed. Congratulations player 1!");
            winningPlayer = 1;
            losingPlayerHits = player2Hits;
            numTurns = player1Turns;
        } else if (player2Hits == 17) {
            System.out.println("Enemy fleet destroyed. Congratulations player 2!");
            winningPlayer = 2;
            losingPlayerHits = player1Hits;
            numTurns = player2Turns;
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 14; j++) {
                if (String.valueOf(shipPositionsPlayerOne[i].charAt(j)).equals("H")) {
                    if (i < 3)
                        player1Top++;
                    else if (i > 2 && i < 7)
                        player1Middle++;
                    else if (i > 6)
                        player1Bottom++;
                }
                if (String.valueOf(shipPositionsPlayerTwo[i].charAt(j)).equals("H")) {
                    if (i < 3)
                        player2Top++;
                    else if (i > 2 && i < 7)
                        player2Middle++;
                    else if (i > 6)
                        player2Bottom++;
                }
            }
        }
        String player1Pattern;
        String player2Pattern;
        if (player1Top >= 9)
            player1Pattern = "Top Heavy";
        else if ( player1Middle >= 9)
            player1Pattern = "Middle Heavy";
        else if ( player1Bottom >= 9)
            player1Pattern = "Bottom Heavy";
        else
            player1Pattern = "Scattered";
        if (player2Top >= 9)
            player2Pattern = "Top Heavy";
        else if ( player2Middle >= 9)
            player2Pattern = "Middle Heavy";
        else if ( player2Bottom >= 9)
            player2Pattern = "Bottom Heavy";
        else
            player2Pattern = "Scattered";
        GameLog gl = new GameLog(winningPlayer , losingPlayerHits,
                numTurns , player1Pattern , player2Pattern );
        File f = new File("GameLog.txt");
        FileOutputStream fos = new FileOutputStream(f);
        PrintWriter pw = new PrintWriter(fos);
        pw.write(gl.toString());
        pw.close();


    }
}
