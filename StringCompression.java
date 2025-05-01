// Implement a method to perform basic string compression using the counts
// of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
// "compressed" string would not become smaller than the original string, your method should return
// the original string. You can assume the string has only uppercase and lowercase letters (a - z). 
public class StringCompression {
    public static String compress(String str) {
        if ((str == null) || (str.length() == 0)) return str; // edge case

        StringBuilder sb = new StringBuilder("");
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == str.charAt(i)) {
                count++;
            } else {
                sb.append(str.charAt(i - 1));
                sb.append(count);
                count = 1;
            } 
        }
        sb.append(str.charAt(str.length() - 1));
        sb.append(count);

        String compressed = sb.toString();
        if (compressed.length() >= str.length()) {
            return str; // if original string length is fewer than the compressed string length.
        }
        return compressed;
    }

    public static void main(String[] args) {
        String str = "aabcccccaaa";
        System.out.println("Original String: " + str);
        System.out.println("Compressed String: " + compress(str));
    }
}

