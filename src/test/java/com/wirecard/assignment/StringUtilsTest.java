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
    public void getFirstNonRepeatedChar_AtFirstMiddleLast() {
        Assert.assertEquals('a',StringUtils.getFirstNonRepeatedChar("abcccb")); // non repeating character is at the first
        Assert.assertEquals('b',StringUtils.getFirstNonRepeatedChar("aabcc"));  // non repeating character is at the middle
        Assert.assertEquals('c',StringUtils.getFirstNonRepeatedChar("abbac"));  // non repeating character is at the last
    }

    /**
     * Checks the correctness when more than one non-repeating characters occur in the string
     */
    @Test
    public void getFirstNonRepeatedChar_ManyNonRepeatingChars_ReturnFirst() {
        Assert.assertEquals('a',StringUtils.getFirstNonRepeatedChar("abcdeff"));
        Assert.assertEquals('c',StringUtils.getFirstNonRepeatedChar("ababcd"));
    }

    /**
     * Checks the correctness when there is a mixture of upper and lower case characters.
     * This function is expected to take into account the count of the occurrence irrespective of the case of the characters
     * Note : The result of the function preserves the case of the character for the non repeating character.
     */
    @Test
    public void getFirstNonRepeatedChar_WithUpperCaseChars_NonCaseSensitive() {
        Assert.assertEquals('b',StringUtils.getFirstNonRepeatedChar("Abacus"));
        Assert.assertEquals('D',StringUtils.getFirstNonRepeatedChar("sDsc")); // Note: Output is expected to be in upper case for this input.
    }

    /**
     * Checking the correctness of the function with a long string
     */
    @Test
    public void getFirstNonRepeatedChar_LongString() {
        Assert.assertEquals('c',StringUtils.getFirstNonRepeatedChar("lksjdfordcklbjfjgofthjvbkmlhjgfojbv90w45dlkjgdlfkjnbbldrijtaawehgkiollkrlsjngdkfjh"));
    }

    /**
     * Checks the correctness of the function when the input is null.
     * The function is expected to result the default value of the character in Java. (ie) \u0000
     */
    @Test
    public void getFirstNonRepeatedChar_NullString_ReturnDefaultCharValue() {
        Assert.assertEquals('\u0000',StringUtils.getFirstNonRepeatedChar(null));
    }

    /**
     * Checks the correctness of the function when the input string is empty.
     * The function is expected to result the default value of the character in Java. (ie) \u0000
     */
    @Test
    public void getFirstNonRepeatedChar_WithEmptyString_ReturnDefaultCharValue() {
        Assert.assertEquals('\u0000',StringUtils.getFirstNonRepeatedChar(""));
    }

    /**
     * Checks the correctness of the function when the input string contains a non repeating white space as the first non repeating character.
     * Whitespace is also a character.
     */
    @Test
    public void getFirstNonRepeatedChar_WithOneWhiteSpace_ReturnWhiteSpace() {
        Assert.assertEquals('\u0020',StringUtils.getFirstNonRepeatedChar(" "));
    }

    /**
     * Checks the correctness of the function when the input string contains repetitive whitespaces and there is no other non repetitive characters.
     * Whitespace is also a character.
     */
    @Test
    public void getFirstNonRepeatedChar_WithRepeatingWhiteSpaces_ReturnDefaultCharValue() {
        Assert.assertEquals('\u0000',StringUtils.getFirstNonRepeatedChar("  "));
    }

    /**
     * Checks the correctness of the functions when the string contains numbers.
     */
    @Test
    public void getFirstNonRepeatedChar_WithNumbers() {
        Assert.assertEquals('1',StringUtils.getFirstNonRepeatedChar("12434"));
        Assert.assertEquals('2',StringUtils.getFirstNonRepeatedChar("2048KB"));
        Assert.assertEquals('K',StringUtils.getFirstNonRepeatedChar("2020KB"));
    }

    /**
     * Checks the correctness of the function when the string contains special characters
     */
    @Test
    public void getFirstNonRepeatedChar_WithSpecialChars() {
        Assert.assertEquals('$',StringUtils.getFirstNonRepeatedChar("#$#*!"));
        Assert.assertEquals('!',StringUtils.getFirstNonRepeatedChar("~|!~|&"));
        Assert.assertEquals('$',StringUtils.getFirstNonRepeatedChar("$1200;"));
    }
}