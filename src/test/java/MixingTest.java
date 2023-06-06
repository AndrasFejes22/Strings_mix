import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MixingTest {

    @Test
    void letterStatistics() {
    }

    @Test
    void checkIfLoverCaseTest() {
        assertTrue(Mixing.checkIfLoverCase('a'));
        assertFalse(Mixing.checkIfLoverCase('A'));
    }

    @Test
    void leftOnlyLettersTest() {
        assertEquals("aaa", Mixing.leftOnlyLetters("A aa!a B&"));
    }

    @Test
    void hasSameCharacterTest() {
        assertTrue(Mixing.hasSameCharacter("abcq", "axu"));
        assertTrue(Mixing.hasSameCharacter("abcq", "axuppp"));
        assertFalse(Mixing.hasSameCharacter("abc", "pxu"));
        assertFalse(Mixing.hasSameCharacter("ab:c", "px:u"));
        assertFalse(Mixing.hasSameCharacter("1ab:c", "1px:u"));
    }

    @Test
    void resultStringTest() {
        /*
        String[] s1 = {"aaaa", "bb", "h"};
        String[] s2 = {"aaa", "bbb", "hh", "c"};
        assertEquals("aaaabbbhhc", Mixing.resultString(s1, s2));
        */

        String[] s3 = {"aaaa", "bb", "h", "cc"};
        String[] s4 = {"aaa", "bbb", "hh", "cc"};
        assertEquals("aaaabbbhhcc", Mixing.resultString(s3, s4));
    }

    @Test
    void mixTest() {
        assertEquals("2:eeeee/2:yy/=:hh/=:rr", Mixing.mix("Are they here", "yes, they are here"));
    }

    @Test
    void letterInAWordTest() {
        assertEquals(2, Mixing.letterInAWord("  letter", 'e'));
    }
}