// Write a method to replace all spaces in a string with '%20'. You may assume that the string
// has sufficient space at the end to hold the additional characters, and that you are given the "true"
// length of the string. (Note: If implementing in Java, please use a character array so that you can
// perform this operation in place.) 
public class URLify {
    public static String URLify(String str, int length) {
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        while ((i < length) && (sb.length() != length)) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                sb.append("%20");
            } else {
                sb.append(ch);
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        int length = str.length();
        System.out.println(str + " becomes " + URLify.URLify(str, length) + ".");
    }
}
