package univ.cnu.lecture.gostop;

/**
 * Created by tchi on 2017. 4. 23..
 */
public class Game {
    private Player[] players;
    private int currentPlayerIndex;

    public Game(Player[] players) {
        this.players = players;
        this.currentPlayerIndex = 0;
    }

    public Player currentPlayer() {
        int index = currentPlayerIndex;
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        return players[index];
    }

    public Card[] putCard(Card playerCard) {
        return new Card[0];
    }
}
