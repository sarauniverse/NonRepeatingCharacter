package com.wirecard.assignment;

import java.util.HashMap;

/**
 * Utils class for the String operations
 */
public class StringUtils {

    /**
     * Returns the first non repeating character in the given string word.
     * It returns the default value of the character \u0000 when the input string is null or an empty string or when there is no non-repeating characters.
     * Does not take into account the case of the characters. (e.g) 'B' and 'b' considered equal.
     * @param word The input string
     * @return The first non repeating character.
     */
    public static char getFirstNonRepeatingChar(String word) {
        Character nonRepeatingCharacter = Character.MIN_VALUE;
        if(word == null) {
            return nonRepeatingCharacter.charValue();
        }
        String wordLowerCase = word.toLowerCase();
        HashMap<Character,Integer> map = new HashMap<>();
        // Count the occurrence of each character and record it in the HashMap
        for(int i=0;i<wordLowerCase.length();i++) {
            Character ch=wordLowerCase.charAt(i);
            Integer count = map.get(ch);
            count = count == null ? 0 : count;
            map.put(ch, ++count);
        }
        // Get the first character with 1 occurrence.
        for(int i=0;i<wordLowerCase.length();i++) {
            Character ch=wordLowerCase.charAt(i);
            int count = map.get(ch);
            if(count == 1) {
                nonRepeatingCharacter=word.charAt(i);
                break;
            }
        }
        return nonRepeatingCharacter.charValue();
    }
}
