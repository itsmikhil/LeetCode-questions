class Solution {
    public void setZeroes(int[][] matrix) {

        // optimal

        // Use first row as column markers
        // Use first column as row markers

        // Problem: matrix[0][0] belongs to both first row and first column.
        // Solution:
        // matrix[0][0] -> marker for first row
        // col0         -> marker for first column

        int col0 = 1;

        
        // Pass 1:
        // Visit every cell.
        // If matrix[i][j] == 0:
        //   - mark its row using matrix[i][0]
        //   - mark its column using matrix[0][j]
        //   - if j == 0, use col0 instead (to avoid conflict at matrix[0][0])
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;

                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        // Pass 2:
        // Ignore first row & first column (they are markers).
        // Zero inner cells based on the markers.
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

       // Finally:
        // If matrix[0][0] == 0 -> zero the first row.
        // If col0 == 0         -> zero the first column.

        if (matrix[0][0] == 0) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}