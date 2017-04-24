package univ.cnu.lecture.gostop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

/**
 * Created by tchi on 2017. 4. 23..
 */
public class GameMockTest {
    private Game game;

    @Test
    public void testPutOneCardAndGainTwoCardForItsMatching() {
        Card puttingCard = new Card();
        Player gamingPlayer = mock(Player.class);
        Plate plate = mock(Plate.class);
        CardStack stack = mock(CardStack.class);

        Player[] players = new Player[] { gamingPlayer };
        game = new Game(players, plate, stack);

        when(gamingPlayer.nextCard())
                .thenReturn(puttingCard);
        when(plate.matchedCard(puttingCard))
                .thenReturn(new Card());

        Player player = game.currentPlayer();
        Card card = player.nextCard();
        Card[] gains = game.putCard(card);

        assertThat(gains.length, is(2));
    }

    @Test
    public void testPutOneCardAndGainFourCardForItsAllMatching() {
        Card puttingCard = new Card();
        Player gamingPlayer = mock(Player.class);
        Plate plate = mock(Plate.class);
        CardStack stack = mock(CardStack.class);

        Player[] players = new Player[] { gamingPlayer };

        game = new Game(players, plate, stack);

        when(gamingPlayer.nextCard())
                .thenReturn(puttingCard);
        when(plate.matchedCard(anyObject()))
                .thenReturn(new Card());
        when(stack.pop())
                .thenReturn(new Card());

        Player player = game.currentPlayer();
        Card card = player.nextCard();
        Card[] gains = game.putCard(card);

        verify(plate,times(2)).remove(anyObject());

        assertThat(gains.length, is(4));
    }

}
