public class Game {
    public Player player;
    public Dealer dealer;
    public boolean isGameOver;

    public Game(){
        player = new Player();
        dealer = new Dealer();
        isGameOver = false;
    }
}
