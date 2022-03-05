import org.junit.Test;
import org.junit.After;
import java.lang.reflect.Field;
import org.junit.Assert;
import org.junit.Before;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.*;
import static org.hamcrest.CoreMatchers.containsString;

import static org.junit.Assert.*;

/**
 * A framework to run public test cases.
 *
 * <p>Purdue University -- CS18000 -- Fall 2021</p>
 *
 * @author Purdue CS
 * @version August 23, 2021
 */
public class RunLocalTest {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestCase.class);
        if (result.wasSuccessful()) {
            System.out.println("Excellent - Test ran successfully");
        } else {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
    }

    /**
     * A set of public test cases.
     *
     * <p>Purdue University -- CS18000 -- Fall 2021</p>
     *
     * @author Purdue CS
     * @version August 23, 2021
     */
    public static class TestCase {
        private final InputStream originalInput = System.in;
        private final PrintStream originalOutput = System.out;
        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayInputStream testIn;
        private final String TA_ERROR_MESSAGE = "You bumped into an error! Please contact a TA immediately.";
        private ByteArrayOutputStream testOut;

        @Before
        public void outputStart() {
            testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));
        }

        @Test(timeout = 1000)
        public void testShipPositions1() {

            String input = "A\n1\nC\n9\nA\n1\nC\n13\nA\n1\nC\n14\nA\n1\nD\n" +
                    "9\nA\n1\nE\n9\nA\n1\nF\n9\nA\n1\nG\n9\nA\n1\nH\n6\nA\n1\n" +
                    "H\n7\nA\n1\nH\n8\nA\n1\nH\n9\nA\n1\nI\n1\nA\n1\nI\n2\nA\n1\nI\n" +
                    "3\nA\n1\nJ\n7\nA\n1\nJ\n8\nA\n1\nJ\n9\n";

            receiveInput(input);

            try {
                PlayGame.main(new String[0]);
            } catch (IOException e) {
                e.printStackTrace();
                fail("Ensure your program handles file reading and writing correctly and has the correct number of scanner calls!");
            }
            String out = getOutput();

            String expectedFull = "Hello, Welcome to Battleship!\n"
                    + "Player 1 - Enter a row letter from A - J\n"
                    + "Player 1 - Enter a column number from 1 - 14\n"
                    + "Value:M\n"
                    + "Player 2 - Enter a row letter from A - J\n"
                    + "Player 2 - Enter a column number from 1 - 14\n"
                    + "Value:H\n"
                    + "Player 1 - Enter a row letter from A - J\n"
                    + "Player 1 - Enter a column number from 1 - 14\n"
                    + "Value:M\n"
                    + "Player 2 - Enter a row letter from A - J\n"
                    + "Player 2 - Enter a column number from 1 - 14\n"
                    + "Value:H\n"
                    + "Player 1 - Enter a row letter from A - J\n"
                    + "Player 1 - Enter a column number from 1 - 14\n"
                    + "Value:M\n"
                    + "Player 2 - Enter a row letter from A - J\n"
                    + "Player 2 - Enter a column number from 1 - 14\n"
                    + "Value:H\n"
                    + "Player 1 - Enter a row letter from A - J\n"
                    + "Player 1 - Enter a column number from 1 - 14\n"
                    + "Value:M\n"
                    + "Player 2 - Enter a row letter from A - J\n"
                    + "Player 2 - Enter a column number from 1 - 14\n"
                    + "Value:H\n"
                    + "Player 1 - Enter a row letter from A - J\n"
                    + "Player 1 - Enter a column number from 1 - 14\n"
                    + "Value:M\n"
                    + "Player 2 - Enter a row letter from A - J\n"
                    + "Player 2 - Enter a column number from 1 - 14\n"
                    + "Value:H\n"
                    + "Player 1 - Enter a row letter from A - J\n"
                    + "Player 1 - Enter a column number from 1 - 14\n"
                    + "Value:M\n"
                    + "Player 2 - Enter a row letter from A - J\n"
                    + "Player 2 - Enter a column number from 1 - 14\n"
                    + "Value:H\n"
                    + "Player 1 - Enter a row letter from A - J\n"
                    + "Player 1 - Enter a column number from 1 - 14\n"
                    + "Value:M\n"
                    + "Player 2 - Enter a row letter from A - J\n"
                    + "Player 2 - Enter a column number from 1 - 14\n"
                    + "Value:H\n"
                    + "Player 1 - Enter a row letter from A - J\n"
                    + "Player 1 - Enter a column number from 1 - 14\n"
                    + "Value:M\n"
                    + "Player 2 - Enter a row letter from A - J\n"
                    + "Player 2 - Enter a column number from 1 - 14\n"
                    + "Value:H\n"
                    + "Player 1 - Enter a row letter from A - J\n"
                    + "Player 1 - Enter a column number from 1 - 14\n"
                    + "Value:M\n"
                    + "Player 2 - Enter a row letter from A - J\n"
                    + "Player 2 - Enter a column number from 1 - 14\n"
                    + "Value:H\n"
                    + "Player 1 - Enter a row letter from A - J\n"
                    + "Player 1 - Enter a column number from 1 - 14\n"
                    + "Value:M\n"
                    + "Player 2 - Enter a row letter from A - J\n"
                    + "Player 2 - Enter a column number from 1 - 14\n"
                    + "Value:H\n"
                    + "Player 1 - Enter a row letter from A - J\n"
                    + "Player 1 - Enter a column number from 1 - 14\n"
                    + "Value:M\n"
                    + "Player 2 - Enter a row letter from A - J\n"
                    + "Player 2 - Enter a column number from 1 - 14\n"
                    + "Value:H\n"
                    + "Player 1 - Enter a row letter from A - J\n"
                    + "Player 1 - Enter a column number from 1 - 14\n"
                    + "Value:M\n"
                    + "Player 2 - Enter a row letter from A - J\n"
                    + "Player 2 - Enter a column number from 1 - 14\n"
                    + "Value:H\n"
                    + "Player 1 - Enter a row letter from A - J\n"
                    + "Player 1 - Enter a column number from 1 - 14\n"
                    + "Value:M\n"
                    + "Player 2 - Enter a row letter from A - J\n"
                    + "Player 2 - Enter a column number from 1 - 14\n"
                    + "Value:H\n"
                    + "Player 1 - Enter a row letter from A - J\n"
                    + "Player 1 - Enter a column number from 1 - 14\n"
                    + "Value:M\n"
                    + "Player 2 - Enter a row letter from A - J\n"
                    + "Player 2 - Enter a column number from 1 - 14\n"
                    + "Value:H\n"
                    + "Player 1 - Enter a row letter from A - J\n"
                    + "Player 1 - Enter a column number from 1 - 14\n"
                    + "Value:M\n"
                    + "Player 2 - Enter a row letter from A - J\n"
                    + "Player 2 - Enter a column number from 1 - 14\n"
                    + "Value:H\n"
                    + "Player 1 - Enter a row letter from A - J\n"
                    + "Player 1 - Enter a column number from 1 - 14\n"
                    + "Value:M\n"
                    + "Player 2 - Enter a row letter from A - J\n"
                    + "Player 2 - Enter a column number from 1 - 14\n"
                    + "Value:H\n"
                    + "Player 1 - Enter a row letter from A - J\n"
                    + "Player 1 - Enter a column number from 1 - 14\n"
                    + "Value:M\n"
                    + "Player 2 - Enter a row letter from A - J\n"
                    + "Player 2 - Enter a column number from 1 - 14\n"
                    + "Value:H\n"
                    + "Enemy fleet destroyed. Congratulations player 2!\n";
            assertEquals("Ensure your PlayGame.java output contains the correct winning information!", expectedFull, out);

            String gameLog = "";
            try {
                FileReader fr = new FileReader("GameLog.txt");
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                while (line != null) {
                    gameLog += line;
                    gameLog += "\n";
                    line = br.readLine();
                }
                fr.close();
                br.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                Assert.fail("Unexpected Exception!");
            }

            String expectedGameLog = "Battleship Game Log:\nWinning Player: Player 2\nHits: 0 - 17\n" +
                    "Number of Turns To Win: 17\nPlayer 1 Board Pattern: Bottom Heavy\nPlayer 2 Board Pattern: Bottom Heavy\n";

            assertEquals("Ensure your GameLog.txt file output is correct",
                    expectedGameLog, gameLog);

        }

        /**
         * UTILITY METHODS BELOW
         */

        private void receiveInput(String str) {
            testIn = new ByteArrayInputStream(str.getBytes());
            System.setIn(testIn);
        }

        private String getOutput() {
            return testOut.toString();
        }

        @After
        public void restoreInputAndOutput() {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }
    }
}