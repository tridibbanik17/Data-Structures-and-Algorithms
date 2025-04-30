// Given two strings, write a method to decide if one is a permutation of the other. 
import java.util.HashMap;
import java.util.Map;

public class PermutationChecker { 
    public static boolean isPermutation(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        Map<Character, Integer> mapA = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            Character ch = a.charAt(i);
            if (mapA.containsKey(ch)) {
                int count = mapA.get(ch);
                mapA.put(ch, count + 1);
            } else {
                mapA.put(ch, 1);
            }
        }

        Map<Character, Integer> mapB = new HashMap<>();
        for (int j = 0; j < b.length(); j++) {
            Character ch = b.charAt(j);
            if (mapB.containsKey(ch)) {
                int count = mapB.get(ch);
                mapB.put(ch, count + 1);
            } else {
                mapB.put(ch, 1);
            }
        }

        return mapA.equals(mapB);
    }

    public static void main(String[] args) {
        String a = "abc";
        String b = "cba";
        String c = "aabc";
        System.out.println(a + " is a permutation of " + b + "?" + " " + PermutationChecker.isPermutation(a, b)); // return true
        System.out.println(a + " is a permutation of " + c + "?" + " " + PermutationChecker.isPermutation(a, c)); // return false
    }
}