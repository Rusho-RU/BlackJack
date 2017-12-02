import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Card {
    private int cardValue;
    private Random randomCard;

    public Card(){
        randomCard = new Random();
        cardValue = getRandom();
    }

    private int getRandom(){
        return randomCard.nextInt(11);
    }

    public int getCardValue(){
        return cardValue;
    }
}
