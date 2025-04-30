// Given a string, write a function to check if it is a permutation of
// a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
// permutation is a rearrangement of letters. The palindrome does not need to be limited to just
// dictionary words.

import java.util.HashMap;
import java.util.Map;
public class PalindromePermutation {
    public static boolean permPalindrome(String str) {
        str = str.toLowerCase().replace(" ", "");
        Map<Character, Integer> map = new HashMap<>();
        int count;
        int odd = 0; 
        int even = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                count = map.get(ch) + 1;
            } else {
                count = 1;
            }
            map.put(ch, count); 
        }

        for (int c : map.values()) {
            if (c % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        return odd <= 1; // Maximum 1 odd length string is accepted.
    }

    public static void main(String[] args) {
        String str = "Tact Coa";
        System.out.println(str + " is a palindrome permutation? " + permPalindrome(str));  
    }
}