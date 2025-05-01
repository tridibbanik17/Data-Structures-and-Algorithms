// Given an image represented by an NxN matrix, where each pixel in the image is 4
// bytes, write a method to rotate the image by 90 degrees. Can you do this in place?

public class RotateMatrix {
    public static boolean rotateImage(int[][] matrix) {
        int n = matrix.length;
        if ((n == 0) || (n != matrix[0].length)) return false; // edge case

        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[last - offset][first]; // col of left becomes row of top

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
        return true;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};

        System.out.println("Original Matrix: ");
        printMatrix(matrix);

        boolean rotated = rotateImage(matrix);
        if (rotated) {
            System.out.println("Rotated Matrix: ");
            printMatrix(matrix);
        } else {
            System.out.println("Rotation failed: Matrix must be non-empty and square.");
        }
    }
}
