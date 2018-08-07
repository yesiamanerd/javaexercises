import java.security.SecureRandom;

/**
 * Created by geoffrey on 2/11/18.
 */
public class Craps {
    private static final SecureRandom secureRandom = new SecureRandom();
    private enum Status {CONTINUE, WON, LOST};
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    public static void main(String[] args){
        int myPoint = 0;
        Status gameStatus;

        int sumOfDice = getSumOfDice();

        GameStatus status = new GameStatus(myPoint, sumOfDice);
        gameStatus = status.getGameStatus();
        myPoint = status.getMyPoint();

        while (gameStatus == Status.CONTINUE){
            sumOfDice = getSumOfDice();

            if(sumOfDice == myPoint)
                gameStatus = Status.WON;
            else
                if(sumOfDice == SEVEN)
                    gameStatus = Status.LOST;
        }

        if (gameStatus == Status.WON)
            System.out.println("Player Wins");
        else
            System.out.println("Player Loses");

    }

    private static int getSumOfDice() {
        int sumOfDice;
        sumOfDice = rollDice();
        System.out.println("Player rolls: " + sumOfDice);
        return sumOfDice;
    }

    private static int rollDice() {
        return (2 + secureRandom.nextInt(6) + secureRandom.nextInt(6));
    }

    private static class GameStatus {
        private int myPoint;
        private int sumOfDice;
        private Status gameStatus;

        public GameStatus(int myPoint, int sumOfDice) {
            this.myPoint = myPoint;
            this.sumOfDice = sumOfDice;
            invoke();
        }

        public int getMyPoint() {
            return myPoint;
        }

        public Status getGameStatus() {
            return gameStatus;
        }

        public void invoke() {
            switch (sumOfDice){
                case SEVEN:
                case YO_LEVEN:
                    gameStatus = Status.WON;
                    break;
                case SNAKE_EYES:
                case TREY:
                case BOX_CARS:
                    gameStatus = Status.LOST;
                    break;
                default:
                    gameStatus = Status.CONTINUE;
                    myPoint = sumOfDice;
                    System.out.printf("Point is %d%n", myPoint);
                    break;
            }
        }
    }
}
