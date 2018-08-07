/*
7.19 (Airline Reservations System) A small airline has just purchased a computer for its new au-
tomated reservations system. You’ve been asked to develop the new system. You’re to write an ap-
plication to assign seats on each flight of the airline’s only plane (capacity: 10 seats).

Your application should display the following alternatives: Please type 1 for First Class and
Please type 2 for Economy . If the user types 1 , your application should assign a seat in the first-
class section (seats 1–5). If the user types 2 , your application should assign a seat in the economy
section (seats 6–10). Your application should then display a boarding pass indicating the person’s
seat number and whether it’s in the first-class or economy section of the plane.

Use a one-dimensional array of primitive type boolean to represent the seating chart of the
plane. Initialize all the elements of the array to false to indicate that all the seats are empty. As
each seat is assigned, set the corresponding element of the array to true to indicate that the seat is
no longer available.

Your application should never assign a seat that has already been assigned. When the economy
section is full, your application should ask the person if it’s acceptable to be placed in the first-class
section (and vice versa). If yes, make the appropriate seat assignment. If no, display the message
"Next flight leaves in 3 hours."
 */


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Ex_0719_AirlineReservationSystem {


    public static void main(String[] args) throws IOException {
        boolean[] economySeats = new boolean[5];
        boolean[] firstClassSeats = new boolean[5];
        Arrays.fill(economySeats, false);
        Arrays.fill(firstClassSeats, false);
        Scanner input = new Scanner(System.in);
        char reservation = 'Y';
        char seatClass;


        while(reservation == 'Y'){
            seatClass = ' ';
            displayTitleSequence(economySeats, firstClassSeats);
            reservation = Character.toUpperCase(input.next().charAt(0));
            if(reservation == 'Y')
                while(seatClass != 'F' && seatClass != 'E') {
                    System.out.printf("%s",
                            "Would you like [F]irst Class or [E]conomy? [F/E]");
                    seatClass = Character.toUpperCase(input.next().charAt(0));
                }

                if(seatClass == 'F'){
                    for(int i = 0; i < firstClassSeats.length; i++)
                        if(firstClassSeats[i] == false){

                        }

                }
        }
    }

    private static void displayTitleSequence(boolean[] economySeats, boolean[] firstClassSeats) {

        for(int i = 0; i < 30; i++)
            System.out.println();

        for(int i = 0; i < 19; i++)
            System.out.printf(" ");
        System.out.printf("%s%n%n", "Airline Reservation Program");

        for(int i = 0; i < 26; i++)
            System.out.printf(" ");
        System.out.printf("%s%n", "Economy Seats");

        displayBoxTop();
        displaySeats(economySeats);
        displayMidLine();
        displaySeats(firstClassSeats);
        displayBoxBottom();

        for(int i = 0; i < 25; i++)
            System.out.printf(" ");
        System.out.printf("%s%n", "First Class Seats");

        System.out.printf("%n%n");
        for(int i = 0; i < 12; i++)
            System.out.printf(" ");
        System.out.printf("%s", "Would you like to reserve a seat ? [Y/N]: ");
    }

    private static void displaySeats(boolean[] seats) {
        for(boolean seat : seats){
            if(seat)
                displayReservedSeatRow();
            else
                displayOpenSeatRow();
        }
    }

    private static void displayReservedSeatRow() {
        displayLeftSide();
        displayReservedSeat();
        displayRightSide();
    }

    private static void displayOpenSeatRow() {
        displayLeftSide();
        displayOpenSeat();
        displayRightSide();
    }

    private static void displayBoxTop(){
        for(int i = 0; i < 30; i++)
            System.out.print(" ");
        System.out.printf("%c%c%c%c%c\n",0x2554, 0x2550, 0x2550, 0x2550, 0x2557);
    }

    private static void displayBoxBottom(){
        for(int i = 0; i < 30; i++)
            System.out.print(" ");
        System.out.printf("%c%c%c%c%c\n",0x255A, 0x2550, 0x2550, 0x2550, 0x255D);
    }

    private static void displayLeftSide(){
        for(int i = 0; i < 30; i++)
            System.out.print(" ");
        System.out.printf("%c ", 0x2551);
    }

    private static void displayRightSide(){
        System.out.printf(" %c\n", 0x2551);
    }

    private static void displayOpenSeat(){
        System.out.printf("%c", 0x25EF);
    }

    private static void displayReservedSeat(){
        System.out.printf("%c", 0x25C9);
    }

    private static void displayMidLine(){
        for(int i = 0; i < 30; i++)
            System.out.print(" ");
        System.out.printf("%c%c%c%c%c\n",0x2560, 0x2550, 0x2550, 0x2550, 0x2563);
    }
}
