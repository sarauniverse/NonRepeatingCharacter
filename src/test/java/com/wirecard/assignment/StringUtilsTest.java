package com.wirecard.assignment;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for the class {@link StringUtils}
 */
public class StringUtilsTest {

    /**
     * Checks the correctness when the non repeating character is at the first, middle and the last positions in the string
     */
    @Test
    public void getFirstNonRepeatingChar_AtFirstMiddleLast() {
        Assert.assertEquals('a',StringUtils.getFirstNonRepeatingChar("abcccb")); // non repeating character is at the first
        Assert.assertEquals('b',StringUtils.getFirstNonRepeatingChar("aabcc"));  // non repeating character is at the middle
        Assert.assertEquals('c',StringUtils.getFirstNonRepeatingChar("abbac"));  // non repeating character is at the last
    }

    /**
     * Checks the correctness when more than one non-repeating characters occur in the string
     */
    @Test
    public void getFirstNonRepeatingChar_ManyNonRepeatingChars_ReturnFirst() {
        Assert.assertEquals('a',StringUtils.getFirstNonRepeatingChar("abcdeff"));
        Assert.assertEquals('c',StringUtils.getFirstNonRepeatingChar("ababcd"));
    }

    /**
     * Checks the correctness when there is a mixture of upper and lower case characters.
     * This function is expected to take into account the count of the occurrence irrespective of the case of the characters
     * Note : The result of the function preserves the case of the character for the non repeating character.
     */
    @Test
    public void getFirstNonRepeatingChar_WithUpperCaseChars_NonCaseSensitive() {
        Assert.assertEquals('b',StringUtils.getFirstNonRepeatingChar("Abacus"));
        Assert.assertEquals('D',StringUtils.getFirstNonRepeatingChar("sDsc")); // Note: Output is expected to be in upper case for this input.
    }

    /**
     * Checking the correctness of the function with a long string
     */
    @Test
    public void getFirstNonRepeatingChar_LongString() {
        Assert.assertEquals('c',StringUtils.getFirstNonRepeatingChar("lksjdfordcklbjfjgofthjvbkmlhjgfojbv90w45dlkjgdlfkjnbbldrijtaawehgkiollkrlsjngdkfjh"));
    }

    /**
     * Checks the correctness of the function when the input is null.
     * The function is expected to result the default value of the character in Java. (ie) \u0000
     */
    @Test
    public void getFirstNonRepeatingChar_NullString_ReturnDefaultCharValue() {
        Assert.assertEquals('\u0000',StringUtils.getFirstNonRepeatingChar(null));
    }

    /**
     * Checks the correctness of the function when the input string is empty.
     * The function is expected to result the default value of the character in Java. (ie) \u0000
     */
    @Test
    public void getFirstNonRepeatingChar_WithEmptyString_ReturnDefaultCharValue() {
        Assert.assertEquals('\u0000',StringUtils.getFirstNonRepeatingChar(""));
    }

    /**
     * Checks the correctness of the function when the input string contains a non repeating white space as the first non repeating character.
     * Whitespace is also a character.
     */
    @Test
    public void getFirstNonRepeatingChar_WithOneWhiteSpace_ReturnWhiteSpace() {
        Assert.assertEquals('\u0020',StringUtils.getFirstNonRepeatingChar(" "));
    }

    /**
     * Checks the correctness of the function when the input string contains repetitive whitespaces and there is no other non repetitive characters.
     * Whitespace is also a character.
     */
    @Test
    public void getFirstNonRepeatingChar_WithRepeatingWhiteSpaces_ReturnDefaultCharValue() {
        Assert.assertEquals('\u0000',StringUtils.getFirstNonRepeatingChar("  "));
    }

    /**
     * Checks the correctness of the functions when the string contains numbers.
     */
    @Test
    public void getFirstNonRepeatingChar_WithNumbers() {
        Assert.assertEquals('1',StringUtils.getFirstNonRepeatingChar("12434"));
        Assert.assertEquals('2',StringUtils.getFirstNonRepeatingChar("2048KB"));
        Assert.assertEquals('K',StringUtils.getFirstNonRepeatingChar("2020KB"));
    }

    /**
     * Checks the correctness of the function when the string contains special characters
     */
    @Test
    public void getFirstNonRepeatingChar_WithSpecialChars() {
        Assert.assertEquals('$',StringUtils.getFirstNonRepeatingChar("#$#*!"));
        Assert.assertEquals('!',StringUtils.getFirstNonRepeatingChar("~|!~|&"));
        Assert.assertEquals('$',StringUtils.getFirstNonRepeatingChar("$1200;"));
    }
}