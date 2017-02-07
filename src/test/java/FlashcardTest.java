import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by frenata on 2/7/17.
 */
public class FlashcardTest {
    @Test
    public void testGetters() throws Exception {
        Flashcard fc = new Flashcard("front","back");

        assertEquals("front", fc.getFront());
        assertEquals("back", fc.getBack());
    }
}