// There are three types of edits that can be performed on strings: insert a character,
// remove a character, or replace a character. Given two strings, write a function to check if they are
// one edit (or zero edits) away. 

public class OneAway {
    public static boolean isOneInsert(String shorter, String longer) {
        if (shorter.length() + 1 != longer.length()) {
            return false;
        } 

        int unmatched = 0;
        int i = 0;
        int j = 0;
        while((i < longer.length()) && (j < shorter.length())) {
            if (longer.charAt(i) != shorter.charAt(j)) {
                i++;
                unmatched++;
                if (unmatched > 1) {
                    return false;
                }
            } else {
                i++;
                j++;
            }
        }
        return true;
    }

    public static boolean isOneRemove(String longer, String shorter) {
        if (longer.length() - 1 != shorter.length()) {
            return false;
        }

        int i = 0;
        int j = 0;
        int unmatched = 0;
        while ((i < longer.length()) && (j < shorter.length())) {
            if (longer.charAt(i) != shorter.charAt(j)) {
                i++;
                unmatched++;
                if (unmatched > 1) {
                    return false;
                } 
            } else {
                i++;
                j++;
            }
        }
        return true;
    }

    public static boolean isOneReplace(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int unmatched = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                unmatched++;
                if (unmatched > 1) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean isOneEdit(String a, String b) {
        if (a.equals(b)) {
            return true; // Zero edit
        }

        String longer;
        String shorter;

        if (a.length() > b.length()) {
            longer = a;
            shorter = b;
        } else {
            longer = b;
            shorter = a;
        }
        return isOneInsert(shorter, longer) || isOneRemove(longer, shorter) || isOneReplace(a, b);
    }

    public static void main(String[] args) {
        System.out.println("Are \"pale\" and \"ple\" one edit? " + isOneEdit("pale", "ple")); // return true
        System.out.println("Are \"pales\" and \"pale\" one edit? " + isOneEdit("pales", "pale")); // return true
        System.out.println("Are \"pale\" and \"bale\" one edit? " + isOneEdit("pale", "bale")); // return true
        System.out.println("Are \"pale\" and \"bake\" one edit? " + isOneEdit("pale", "bake")); // return false
    }
}