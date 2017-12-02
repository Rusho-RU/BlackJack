import java.util.Scanner;

import static java.lang.Thread.sleep;

public class BlackJack {
    private static Game game = new Game();
    private static int turn;
    private static int [] cardList = new int[10];

    public static int[] getCardList(){
        return cardList;
    }

    private static void check(){
        if(game.player.getTotalPoint() > 21){
            System.out.println("Player lost.");
            game.isGameOver = true;
        }

        else if(game.dealer.getTotalPoint() > 21){
            System.out.println("Dealer lost.");
            game.isGameOver = true;
        }
    }

    public static void main(String args[]){
        System.out.println("Welcome to Mitchell's blackjack program!");

        int card1 = game.player.hit();
        int card2 = game.player.hit();

        System.out.println("You get a " + card1 + " and a " + card2 + ".");
        System.out.println("Your total is " + game.player.getTotalPoint() + ".\n");

        card1 = game.dealer.hit();
        System.out.println("The dealer has a " + card1 + " showing, and a hidden card.");
        System.out.println("His total is hidden.\n");

        game.dealer.hit();
        String decision;
        Scanner scan = new Scanner(System.in);
        turn = 1;
        boolean willShow = false;

        do{
            if(turn == 1){
                System.out.println("Would you like to \"hit\" or \"stay\"?");
                decision = scan.next();
                if(decision.charAt(0) == 'h' || decision.charAt(0) == 'H') {
                    card1 = game.player.hit();
                    System.out.println("You drew a " + card1 + '.');
                    System.out.println("Your total is "  + game.player.getTotalPoint() + ".\n");
                }

                else {
                    turn = 2;
                    System.out.println("Okay, dealer's turn.\n");
                }
            }

            else if(turn == 2) {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (game.player.getTotalPoint() > game.dealer.getTotalPoint()) {
                    System.out.println("Dealer chooses to hit.");
                    card1 = game.dealer.hit();
                    System.out.println("He draws a " + card1 + ".");

                    if (willShow)
                        System.out.println("His total is " + game.player.getTotalPoint() + ".\n");
                    else
                        System.out.println("His total is hidden.\n");

                    if (game.dealer.getTotalPoint() > 10) {
                        try {
                            sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        card1 = game.dealer.hit();
                        willShow = true;
                        System.out.println("Dealer's showing point is greater than 10!!");
                        System.out.println("Hidden card value was " + card1 + ".");
                        System.out.println("His total is " + game.dealer.getTotalPoint() + ".\n");
                    }
                }

                else {
                    try {
                        sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    turn = 1;
                    System.out.println("Dealer chooses to stay.\n");
                }
            }

            check();

        } while(!game.isGameOver);
    }
}
