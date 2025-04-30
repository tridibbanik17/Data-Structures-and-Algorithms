// Write a method to replace all spaces in a string with '%20'. You may assume that the string
// has sufficient space at the end to hold the additional characters, and that you are given the "true"
// length of the string. (Note: if implementing in Java, please use a character array so that you can
// perform this operation in place.) 

public class URLifyOptimized {
    public static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        int index = trueLength + spaceCount * 2; // for each space, add 3 characters, so net increase in characters is 2.

        if (index < str.length) str[index] = '\0'; // End of array

        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index -= 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    public static void main(String[] args) {
        String input = "Mr John Smith    "; // true length is 13 (excluding extra spaces)
        int trueLength = 13;
        char[] charArr = input.toCharArray();

        replaceSpaces(charArr, trueLength);
        System.out.println("Input:  \"" + input + "\"");
        System.out.println("Output: \"" + new String(charArr) + "\"");
    }
}
