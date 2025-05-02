// Assume you have a method isSubstringwhich checks if oneword is a substring
// of another. Given two strings, sl and s2, write code to check if s2 is a rotation of s1 using only one
// call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").

public class StringRotation {
    
    public static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length() || s1.length() == 0) {
            return false;
        }

        String s1s1 = s1 + s1;
        return isSubstring(s1s1, s2);
    }

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(s1 + " is a rotation of " + s2 + "? " + isRotation(s1, s2));
    }
}