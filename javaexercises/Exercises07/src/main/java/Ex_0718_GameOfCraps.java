/*
7.18 (Game of Craps) Write an application that runs 1,000,000 games of craps (Fig. 6.8) and
answers the following questions:
a) How many games are won on the first roll, second roll, ..., twentieth roll and after the
twentieth roll?
b) How many games are lost on the first roll, second roll, ..., twentieth roll and after the
twentieth roll?
c) What are the chances of winning at craps? [Note: You should discover that craps is one
of the fairest casino games. What do you suppose this means?]
d) What is the average length of a game of craps?
e) Do the chances of winning improve with the length of the game?
 */


import java.security.SecureRandom;

public class Ex_0718_GameOfCraps {

    // create secure random number generator for use in method rollDice
    private static final SecureRandom randomNumbers = new SecureRandom();

    // enum type with constants that represent the game status
    private enum Status { CONTINUE, WON, LOST }

    // constants that represent common rolls of the dice
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    public static void main(String[] args){
        int numWon = 0;
        int numLost = 0;
        int totalGames = 36000000;
        int[] freqWin = new int[100];
        int[] freqLost = new int[100];

        for(int i = 0; i < totalGames; i++) {
            int result = playGame();
            if (result > 0) {
                //System.out.printf("Player wins in %d rolls%n", result);
                ++freqWin[result];
                numWon++;
            }
            else {
                //System.out.printf("Player loses in %d rolls%n", (result * -1));
                ++freqLost[result * -1];
                numLost++;
            }
        }

        System.out.printf("Number of games won: %d%n", numWon);
        System.out.printf("Number of games lost: %d%n", numLost);
        System.out.printf("You have a %.2f%% chance of winning.%n%n", (((double)numWon/((double)numWon + (double)numLost) * 100)));
        System.out.printf("%nFrequency of rolls by winners:%n");
        displayFrequency(freqWin);
        System.out.printf("%nFrequency of rolls by losers:%n");
        displayFrequency(freqLost);

    }

    private static void displayFrequency(int[] freq) {
        System.out.printf("%5s%12s%n", "Rolls", "Frequency");
        for (int x = 1; x < freq.length; x++){
            System.out.printf("%5d%12d%n", x, freq[x]);
        }
    }

    private static int playGame() {
        int myPoint = 0; // point if no win or loss on first roll
        Status gameStatus; // can contain CONTINUE, WON or LOST
        int turns = 1;
        int sumOfDice = rollDice(); // first roll of the dice

        // determine game status and point based on first roll
        switch (sumOfDice)
        {
            case SEVEN: // win with 7 on first roll
            case YO_LEVEN: // win with 11 on first roll
                gameStatus = Status.WON;
                break;
            case SNAKE_EYES: // lose with 2 on first roll
            case TREY: // lose with 3 on first roll
            case BOX_CARS: // lose with 12 on first roll
                gameStatus = Status.LOST;
                break;
            default: // did not win or lose, so remember point
                gameStatus = Status.CONTINUE; // game is not over
                myPoint = sumOfDice; // remember the point
                //System.out.printf("Point is %d%n", myPoint);
                break;
        }

        // while game is not complete
        while ( gameStatus == Status.CONTINUE ) // not WON or LOST
        {
            sumOfDice = rollDice(); // roll dice again
            turns++;
            // determine game status
            if (sumOfDice == myPoint) // win by making point
                gameStatus = Status.WON ;
            else
            if (sumOfDice == SEVEN) // lose by rolling 7 before point
                gameStatus = Status.LOST;
        }

        // display won or lost message
        if ( gameStatus != Status.WON ) {
            //System.out.printf("Player wins in %d turns%n", turns);
        //}
        //else {
            //System.out.printf("Player loses in %d turns%n", turns);
            turns *= -1;
        }

        return turns;
    }

    // roll dice, calculate sum and display results
    public static int rollDice(){
        // pick random die values
        int die1 = 1 + randomNumbers.nextInt(6); // first die roll
        int die2 = 1 + randomNumbers.nextInt(6); // second die roll
        int sum = die1 + die2; // sum of die values
        // display results of this roll
        //System.out.printf("Player rolled %d + %d = %d%n",
        //        die1, die2, sum);
        return sum;
    }
}
