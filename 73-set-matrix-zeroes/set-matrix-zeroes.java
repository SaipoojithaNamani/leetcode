class Solution {
    public void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if first row contains 0
        for (int col = 0; col < cols; col++) {
            if (matrix[0][col] == 0) {
                firstRowZero = true;
            }
        }

        // Check if first column contains 0
        for (int row = 0; row < rows; row++) {
            if (matrix[row][0] == 0) {
                firstColZero = true;
            }
        }

        // Use first row and first column as markers
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {

                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        // Set marked rows to zero
        for (int row = 1; row < rows; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 1; col < cols; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        // Set marked columns to zero
        for (int col = 1; col < cols; col++) {
            if (matrix[0][col] == 0) {
                for (int row = 1; row < rows; row++) {
                    matrix[row][col] = 0;
                }
            }
        }

        // Finally handle first row
        if (firstRowZero) {
            for (int col = 0; col < cols; col++) {
                matrix[0][col] = 0;
            }
        }

        // Finally handle first column
        if (firstColZero) {
            for (int row = 0; row < rows; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}