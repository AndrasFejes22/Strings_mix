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
    void mixTest() {
        assertEquals("2:eeeee/2:yy/=:hh/=:rr", Mixing.mix("Are they here", "yes, they are here"));

        assertEquals("1:ooo/1:uuu/2:sss/=:nnn/1:ii/2:aa/2:dd/2:ee/=:gg", Mixing.mix("looping is fun but dangerous", "less dangerous than coding"));

        assertEquals("1:aaa/1:nnn/1:gg/2:ee/2:ff/2:ii/2:oo/2:rr/2:ss/2:tt", Mixing.mix(" In many languages", " there's a pair of functions"));

        assertEquals("1:ee/1:ll/1:oo", Mixing.mix("Lords of the Fallen", "gamekult"));

        assertEquals("", Mixing.mix("codewars", "codewars"));

        assertEquals("1:nnnnn/1:ooooo/1:tttt/1:eee/1:gg/1:ii/1:mm/=:rr", Mixing.mix("A generation must confront the looming ", "codewarrs"));

    }

    @Test
    void letterInAWordTest() {
        assertEquals(2, Mixing.letterInAWord("  letter", 'e'));
    }
}