import java.security.SecureRandom;

public class DeckOfCards0709 {
    private Card0709[] deck;
    private int currentCard;
    private static final int NUMBER_OF_CARDS = 52;
    // random number generator
    private static final SecureRandom randomNumber = new SecureRandom();

    public DeckOfCards0709(){
        String[] faces = {
                "Ace", "Deuce", "Two", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"
        };
        String[] suits = {
                "Spades", "Diamonds", "Clubs", "Hearts"
        };

        deck = new Card0709[NUMBER_OF_CARDS];
        currentCard = 0;

        for(int count = 0; count < deck.length; count++){
            deck[count] = new Card0709(faces[count % 13], suits[count/13]);
        }
    }

    public void shuffle(){
        currentCard = 0;

        for(int first = 0; first < deck.length; first++){
            int second = randomNumber.nextInt(NUMBER_OF_CARDS);

            Card0709 temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }

    public Card0709 dealCard(){
        if(currentCard < deck.length)
            return deck[currentCard++];
        else
            return null;
    }

}
