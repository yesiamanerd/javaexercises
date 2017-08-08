public class Card0709 {
    private final String face;
    private final String suit;

    public Card0709(String cardFace, String cardSuit){
        this.face = cardFace;
        this.suit = cardSuit;
    }

    public String toString(){
        return face + " of " + suit;
    }
}
