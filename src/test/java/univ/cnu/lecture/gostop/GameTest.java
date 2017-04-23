package univ.cnu.lecture.gostop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by tchi on 2017. 4. 23..
 */
public class GameTest {
    private Game game;

    @Test
    public void testPutOneCardAndGainNothing() {
        Player[] players = new Player[] { new Player(), new Player(), new Player() };
        game = new Game(players);

        Player player = game.currentPlayer();
        Card card = player.nextCard();
        Card[] gains = game.putCard(card);

        assertThat(gains.length, is(0));
    }

    @Test
    public void testPutOneCardAndGainTwoCardForItsMatching() {
        Card puttingCard = new Card();
        Player gamingPlayer = new Player(new Card[] { puttingCard });
        Player[] players = new Player[] { gamingPlayer };
        Plate plate = new Plate(new Card[] { puttingCard });
        game = new Game(players, plate);

        Player player = game.currentPlayer();
        Card card = player.nextCard();
        Card[] gains = game.putCard(card);

        assertThat(gains.length, is(2));
    }
}
