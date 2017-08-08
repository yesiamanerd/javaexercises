public class DeckOfCardsTest0711 {
    public static void main(String[] args){
        DeckOfCards0709 myDeckOfCards = new DeckOfCards0709();
        myDeckOfCards.shuffle();

        for(int i = 1; i <= 52; i++){
            // deal and display a card
            System.out.printf("%-19s", myDeckOfCards.dealCard());

            if(i % 4 ==0)
                System.out.println();
        }

    }
}
