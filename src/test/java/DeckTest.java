import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

/**
 * Created by Jonathan on 2/8/2017.
 */
public class DeckTest {
    @Test
    public void shouldAddCardToDeck() throws Exception {
        Deck dc = new Deck();
        Flashcard fc = new Flashcard("front", "back");
        dc.addCard(fc);

        assertEquals(1, dc.getDeck().size());
    }

    @Test
    public void shouldAddCardsToDeck() throws Exception {
        Deck dc = this.get52CardDeck();

        assertEquals(52, dc.getDeck().size());
    }

    @Test
    public void shouldGetNotFrontAndNotBackFromDeckList() throws Exception {
        Deck dc = new Deck();

        Flashcard fc1 = new Flashcard("frente", "espalde");
        dc.addCard(fc1);
        Flashcard fc2 = new Flashcard("front", "back");
        dc.addCard(fc2);
        Flashcard fc3 = new Flashcard("notFront", "notBack");
        dc.addCard(fc3);
        Flashcard fc4 = new Flashcard("front", "back");
        dc.addCard(fc4);
        Flashcard fc5 = new Flashcard("de face", "arriere");
        dc.addCard(fc5);

        //index is zero based.
        Flashcard result1 = dc.getCard(0);
        Flashcard result2 = dc.getCard(2);
        Flashcard result3 = dc.getCard(4);


        assertEquals("frente", result1.getFront());
        assertEquals("espalde", result1.getBack());
        assertEquals("notFront", result2.getFront());
        assertEquals("notBack", result2.getBack());
        assertEquals("de face", result3.getFront());
        assertEquals("arriere", result3.getBack());
    }

    @Test
    public void shouldShuffleDeck() throws Exception {
        Deck shuffledDeck = this.get52CardDeck();
        List<?> preShuffledDeck = shuffledDeck.getDeck();
        List<?> postShuffledDeck = shuffledDeck.shuffle();

        assertFalse(preShuffledDeck.equals(postShuffledDeck));
    }

    private Deck get52CardDeck() {
        Deck dc = new Deck();

        for (int i = 0; i < 52; i++){
            String currentIndex = Integer.toString(i);

            Flashcard fc = new Flashcard("front" + currentIndex, "back" + currentIndex);
            dc.addCard(fc);
        }
        return dc;
    }
}
