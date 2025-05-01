// Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
// column are set to 0. 
public class ZeroMatrix {
    public void setToZero(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] zeroRows = new boolean[m];
        boolean[] zeroCols = new boolean[n];

        // Record rows and columns to zero
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        // Zero out marked rows
        for (int i = 0; i < m; i++) {
            if (zeroRows[i] == true) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero out marked columns
        for (int j = 0; j < n; j++) {
            if (zeroCols[j] == true) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}