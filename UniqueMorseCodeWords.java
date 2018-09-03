//***********************************************************************
//* https://leetcode.com/problems/unique-morse-code-words/description/
//* International Morse Code defines a standard encoding where each 
//* letter is mapped to a series of dots and dashes, as follows: "a" 
//* maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
//* For convenience, the full table for the 26 letters of the English 
//* alphabet is given.
//* Given a string array of words, each word can be written as a 
//* concatenation of the Morse code of each letter. For example, 
//* "cab" can be written as "-.-.-....-", (which is the concatenation 
//* "-.-." + "-..." + ".-"). We'll call such a concatenation, the 
//* transformation of a word.
//* This program returns the number of different transformations among
//* all words we have.
//*
//***********************************************************************

import java.util.HashSet;
import java.util.Random;
import java.util.Arrays;

class UniqueMorseCodeWords {
    public static int uniqueMorseRep(String[] words) {
        HashSet<String> set = new HashSet<>();
        String[] morseTable = {".-","-...","-.-.","-..",".","..-.","--.",
        "....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
        "...","-","..-","...-",".--","-..-","-.--","--.."};
        for(String word : words) {
            String formedMorseWord = "";
            // use ASCII character num to find index in morseTable 
            // corresponding to char c. then form word in morse
            for(char c : word.toCharArray()) {
                //lower case character 'a' is 97 in ASCII numbering. 
                // (ex. 'b' - 'a' is equal to 98 - 97 = 1)
                formedMorseWord += morseTable[c-'a'];
            }
            set.add(formedMorseWord);
        }
        return set.size();
    }
    public static void main(String[] args) {
        // 1) create test input by forming random words
        Random r = new Random();
        int numWords = r.nextInt(99)+1; // random number of words in input array words[]
        String[] words = new String [numWords];
        for(int i=0; i<numWords; ++i)
            words[i] = UseStringBuilder.getSaltString();
        System.out.println(Arrays.toString(words));
        
        // OR 2) use given input array
        //String[] words = {"gin", "zen", "gig", "msg"};
        
        // test the method
        System.out.println(uniqueMorseRep(words));
    }
}
