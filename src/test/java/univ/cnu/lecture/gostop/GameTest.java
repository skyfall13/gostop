package univ.cnu.lecture.gostop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by tchi on 2017. 4. 23..
 */
public class GameTest {
    private Game game;

    @Test
    public void testPutOneCardAndGainNothing() {
        Player[] players = new Player[] { new Player(new Card[0]) };
        Plate dontCarePlate = null;
        CardStack stack = null;
        game = new Game(players, dontCarePlate, stack);

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
        CardStack stack = null;
        game = new Game(players, plate, stack);

        Player player = game.currentPlayer();
        Card card = player.nextCard();
        Card[] gains = game.putCard(card);

        assertThat(gains.length, is(2));
    }

    @Test
    public void testPutOneCardAndGainFourCardForItsAllMatching() {
        fail("Make it!");
    }
}
