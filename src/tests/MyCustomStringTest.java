package tests;
// Billups Tillman
// SWE3643 - Software Testing and Quality Assurance
// Assignment #4
// 03/09/2024
import edu.kennesaw.seclass.MyCustomString;
import edu.kennesaw.seclass.MyCustomStringInterface;
import edu.kennesaw.seclass.MyIndexOutOfBoundsException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @BeforeEach
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @AfterEach
    public void tearDown() {
        mycustomstring = null;
    }

    /*
     *
     * Class: MyCustomString
     * Method: countNumbers()
     *
     */

    // Testing for counting numbers in a string with numbers mixed into words
    // Expected: 9
    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("H3y, l3t'5 put s0me d161ts in this 5tr1n6!11!!");
        assertEquals(9, mycustomstring.countNumbers());
    }

    // Testing for counting numbers in a string with no numbers
    // Expected: 0
    @Test
    public void testCountNumbers2() {
        mycustomstring.setString("BillupsTillmanWasHere");
        assertEquals(0, mycustomstring.countNumbers());
    }

    // Testing for counting numbers in a string with numbers separated by alphabetic characters
    // Expected: 3
    @Test
    public void testCountNumbers3() {
        mycustomstring.setString("123abc456def789");
        assertEquals(3, mycustomstring.countNumbers());
    }

    // Testing for counting numbers in a string with a single number
    // Expected: 1
    @Test
    public void testCountNumbers4() {
        mycustomstring.setString("123");
        assertEquals(1, mycustomstring.countNumbers());
    }

    // Testing for counting numbers when there are spaces present
    // Expected: 5
    @Test
    public void testCountNumbers5() {
        mycustomstring.setString("1 2 3 4 5");
        assertEquals(5, mycustomstring.countNumbers());
    }

    // Testing for counting numbers in a string with numbers separated by non-numeric characters
    // Expected: 3
    @Test
    public void testCountNumbers6() {
        mycustomstring.setString("Numbers: 1, 2, 3");
        assertEquals(3, mycustomstring.countNumbers());
    }

    // Testing for counting numbers in a string with special characters and spaces
    // Expected: 2
    @Test
    public void testCountNumbers7() {
        mycustomstring.setString("!@#$%^&*() 123 45 !@#$%^&*()");
        assertEquals(2, mycustomstring.countNumbers());
    }

    // Testing for counting numbers in an empty string
    // Expected: 0
    @Test
    public void testCountNumbers8() {
        mycustomstring.setString("");
        assertEquals(0, mycustomstring.countNumbers());
    }

    // Testing for counting numbers in a null string
    // Expected: 0
    @Test
    public void testCountNumbers9() {
        mycustomstring.setString(null);
        assertEquals(0, mycustomstring.countNumbers());
    }

    // Testing for counting numbers in a string with leading zeros
    // Expected: 3
    @Test
    public void testCountNumbers10() {
        mycustomstring.setString("00123abc00456def00789");
        assertEquals(3, mycustomstring.countNumbers());
    }

    /*
        *
        * Class: MyCustomString
        * Method: reverseNCharacters(int n, boolean padded)
        *
     */

    // Testing for reversing 4 character groups in a sentence
    // Expected: "etePiP r repkcipa decep fo kcip delkpep srep."
    @Test
    public void testReverseNCharacters1() {
        mycustomstring.setString("Peter Piper picked a peck of pickled peppers.");
        assertEquals("etePiP r repkcipa decep fo kcip delkpep srep.", mycustomstring.reverseNCharacters(4, false));
    }

    // Testing for reversing 4 character groups in a sentence with padding 'X' for incomplete groups
    // Expected: "etePiP r repkcipa decep fo kcip delkpep srepXXX."
    @Test
    public void testReverseNCharacters2() {
        mycustomstring.setString("Peter Piper picked a peck of pickled peppers.");
        assertEquals("etePiP r repkcipa decep fo kcip delkpep srepXXX.", mycustomstring.reverseNCharacters(4, true));
    }

    // Testing for reversing 4 character groups with padding 'X' for incomplete groups, no space
    // Expected: "lliBTspumlliXXna"
    @Test
    public void testReverseNCharacters3() {
        mycustomstring.setString("BillupsTillman");
        assertEquals("lliBTspumlliXXna", mycustomstring.reverseNCharacters(4, true));
    }

    // Testing for reversing with an empty string, result should also be an empty string
    // Expected: ""
    @Test
    public void testReverseNCharacters4() {
        mycustomstring.setString("");
        assertEquals("", mycustomstring.reverseNCharacters(1, false));
    }

    // Testing for reversing every character when input is nums
    // Expected: "54321"
    @Test
    public void testReverseNCharacters5() {
        mycustomstring.setString("12345");
        assertEquals("54321", mycustomstring.reverseNCharacters(5, false));
    }

    // Testing for reversing the first 2 character groups
    // Expected: "BADCE"
    @Test
    public void testReverseNCharacters6() {
        mycustomstring.setString("ABCDE");
        assertEquals("BADCE", mycustomstring.reverseNCharacters(2, false));
    }

    // Testing for reversing every character with padding 'X' for incomplete chars
    // Expected: "XDCBA"
    @Test
    public void testReverseNCharacters7() {
        mycustomstring.setString("ABCD");
        assertEquals("XDCBA", mycustomstring.reverseNCharacters(5, true));
    }

    // Testing for reversing every character without padding
    // Expected: "!dlroW ,olleH"
    @Test
    public void testReverseNCharacters8() {
        mycustomstring.setString("Hello, World!");
        assertEquals("!dlroW ,olleH", mycustomstring.reverseNCharacters(13, false));
    }

    // Testing for reversing 9 groups, no padding
    // Expected: "P spulliBiT yzinihIII namll"
    @Test
    public void testReverseNCharacters9() {
        mycustomstring.setString("Billups Phinizy Tillman III");
        assertEquals("P spulliBiT yzinihIII namll", mycustomstring.reverseNCharacters(9, false));
    }

    // Testing for reversing 100 groups, padding enabled
    // Expected: "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXIII namlliT yzinihP spulliB"
    @Test
    public void testReverseNCharacters10() {
        mycustomstring.setString("Billups Phinizy Tillman III");
        assertEquals("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXIII namlliT yzinihP spulliB", mycustomstring.reverseNCharacters(100, true));
    }

    // Testing for reversing entire alphabet
    // Expected: "zyxwvutsrqponmlkjihgfedcba"
    @Test
    public void testReverseNCharacters11() {
        mycustomstring.setString("abcdefghijklmnopqrstuvwxyz");
        assertEquals("zyxwvutsrqponmlkjihgfedcba", mycustomstring.reverseNCharacters(26, false));
    }

    // Testing for reversing null string, should throw NullPointerException
    // Expected: NullPointerException
    @Test
    public void reverseNCharacters12() {
        mycustomstring.setString(null);
        assertThrows(NullPointerException.class, () -> mycustomstring.reverseNCharacters(5, true));
    }

    // Testing for reversing with n=0, should throw IllegalArgumentException
    // Expected: IllegalArgumentException
    @Test
    public void reverseNCharacters13() {
        mycustomstring.setString("Hello");
        assertThrows(IllegalArgumentException.class, () -> mycustomstring.reverseNCharacters(0, true));
    }

    // Testing for reversing with special characters
    // Expected: "321a#@4cb$65ed%87f*&9"
    @Test
    public void testReverseNCharacters14() {
        mycustomstring.setString("123@#abc456$%def789&*");
        assertEquals("321a#@4cb$65ed%87f*&9", mycustomstring.reverseNCharacters(3, false));
    }

    /*
     *
     * Class: MyCustomString
     * Method: convertDigitsToNamesInSubstring(int startPosition, int endPosition)
     *
     */


    // Testing for converting digits to names in a string with mixed characters & Special characters
    // Expected: "H3y, l3t'5 put 5Zerome dOnesixonets in this 5tr1n6!11!!"
    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!!");
        mycustomstring.convertDigitsToNamesInSubstring(17, 24);
        assertEquals("H3y, l3t'5 put 5Zerome dOnesixonets in this 5tr1n6!11!!", mycustomstring.getString());
    }

    // Testing for converting digits to names in a string with only numbers
    // Expected: "Testing Onetwothree"
    @Test
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.setString("Testing 123");
        mycustomstring.convertDigitsToNamesInSubstring(9, 11);
        assertEquals("Testing Onetwothree", mycustomstring.getString());
    }

    // Testing for converting digits to names in a string with mixed characters
    // Expected: "BThreethree TOnellm4n the 3rd"
    @Test
    public void testConvertDigitsToNamesInSubstring3() {
        mycustomstring.setString("B33 T1llm4n the 3rd");
        mycustomstring.convertDigitsToNamesInSubstring(1, 6);
        assertEquals("BThreethree TOnellm4n the 3rd", mycustomstring.getString());
    }

    // Testing for converting digits to names in a string with only numbers
    // Expected: "abcOnetwothreedef"
    @Test
    public void testConvertDigitsToNamesInSubstring4() {
        mycustomstring.setString("abc123def");
        mycustomstring.convertDigitsToNamesInSubstring(4, 6);
        assertEquals("abcOnetwothreedef", mycustomstring.getString());
    }

    // Testing for converting digits to names in a string with mixed characters and no spaces
    // Expected: "ATwoBThreeCFourDFiveESixFSevenGEightH9I0J"
    @Test
    public void testConvertDigitsToNamesInSubstring5() {
        mycustomstring.setString("A2B3C4D5E6F7G8H9I0J");
        mycustomstring.convertDigitsToNamesInSubstring(1, 15);
        assertEquals("ATwoBThreeCFourDFiveESixFSevenGEightH9I0J", mycustomstring.getString());
    }

    // Testing for converting digits to names in a string with a late number
    // Expected: "Woah, there isn't any digits here Zero.o"
    @Test
    public void testConvertDigitsToNamesInSubstring6() {
        mycustomstring.setString("Woah, there isn't any digits here 0.o");
        mycustomstring.convertDigitsToNamesInSubstring(1, 37);
        assertEquals("Woah, there isn't any digits here Zero.o", mycustomstring.getString());
    }

    // Testing for converting digits to names in a string with 3 numbers listed as 1
    // Expected: "AlphabetOnetwothree"
    @Test
    public void testConvertDigitsToNamesInSubstring7() {
        mycustomstring.setString("Alphabet123");
        mycustomstring.convertDigitsToNamesInSubstring(9, 11);
        assertEquals("AlphabetOnetwothree", mycustomstring.getString());
    }

    // Testing for converting digits to names in a string with only a space
    // Expected: " "
    @Test
    public void testConvertDigitsToNamesInSubstring8() {
        mycustomstring.setString(" ");
        mycustomstring.convertDigitsToNamesInSubstring(1, 1);
        assertEquals(" ", mycustomstring.getString());
    }

    // Testing for converting digits to names in a string with special characters
    // Expected: "!@#$%^&*()Onetwo34!!66^5$4$$"
    @Test
    public void testConvertDigitsToNamesInSubstring9() {
        mycustomstring.setString("!@#$%^&*()1234!!66^5$4$$");
        mycustomstring.convertDigitsToNamesInSubstring(1, 12);
        assertEquals("!@#$%^&*()Onetwo34!!66^5$4$$", mycustomstring.getString());
    }

    // Testing for converting digits to names in a string with mixed characters, numbers, and no spaces
    // Expected: "Nine87654321nineeightsevensixfivefourthreetwoonezero"
    @Test
    public void testConvertDigitsToNamesInSubstring10() {
        mycustomstring.setString("987654321nineeightsevensixfivefourthreetwoonezero");
        mycustomstring.convertDigitsToNamesInSubstring(1, 1);
        assertEquals("Nine87654321nineeightsevensixfivefourthreetwoonezero", mycustomstring.getString());
    }

    // Testing for converting digits to names in a string with only one number
    // Expected: "One"
    @Test
    public void testConvertDigitsToNamesInSubstring11() {
        mycustomstring.setString("1");
        mycustomstring.convertDigitsToNamesInSubstring(1, 1);
        assertEquals("One", mycustomstring.getString());
    }

    // Testing for converting digits to names in a null string, should throw NullPointerException
    // Expected: NullPointerException
    @Test
    public void testConvertDigitsToNamesInSubstring12() {
        mycustomstring.setString(null);
        assertThrows(NullPointerException.class, () -> mycustomstring.convertDigitsToNamesInSubstring(1, 1));
    }

    // Testing for converting digits to names in a string with invalid range, should throw IllegalArgumentException
    // Expected: IllegalArgumentException
    @Test
    public void testConvertDigitsToNamesInSubstring13() {
        mycustomstring.setString("Hello");
        assertThrows(IllegalArgumentException.class, () -> mycustomstring.convertDigitsToNamesInSubstring(5, 1));
    }

    // Testing for converting digits to names in a string with a range that is out of bounds, should throw MyIndexOutOfBoundsException
    // Expected: MyIndexOutOfBoundsException
    @Test
    public void testConvertDigitsToNamesInSubstring14() {
        mycustomstring.setString("Hello");
        assertThrows(MyIndexOutOfBoundsException.class, () -> mycustomstring.convertDigitsToNamesInSubstring(1, 6));
    }
}
