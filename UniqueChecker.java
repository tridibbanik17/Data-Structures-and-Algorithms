// Implement an algorithm to determine if a string has all unique characters.
import java.util.HashSet;
import java.util.Set;

public class UniqueChecker {
    public static Boolean isUnique(String str) {
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (seen.contains(ch)) {
                return false;
            } else {
                seen.add(ch);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String unique = "abc";
        String repeat = "aabc";
        System.out.println("Is " + unique + " unique?" + " " + UniqueChecker.isUnique(unique)); // return true
        System.out.println("Is " + repeat + " unique?" + " " + UniqueChecker.isUnique(repeat)); // return false
    }
}
