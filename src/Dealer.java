public class Dealer {
    private int totalPoint;

    public Dealer(){
        totalPoint = 0;
    }

    public int getTotalPoint(){
        return totalPoint;
    }

    private boolean isAvailable(int cardValue){
        int[] cardList = BlackJack.getCardList();
        if(cardValue > 1 && cardList[cardValue-2] < 4)
            return true;
        return false;
    }

    public int hit() {
        Card card;

        do {
            card = new Card();
        } while (isAvailable(card.getCardValue()) == false);

        int[] cardList = BlackJack.getCardList();
        cardList[card.getCardValue() - 2]++;

        totalPoint += card.getCardValue();
        return card.getCardValue();
    }
}
