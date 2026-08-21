import java.util.*;

class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific: top row
        for (int col = 0; col < cols; col++) {
            dfs(heights, pacific, 0, col);
        }

        // Pacific: left column
        for (int row = 0; row < rows; row++) {
            dfs(heights, pacific, row, 0);
        }

        // Atlantic: bottom row
        for (int col = 0; col < cols; col++) {
            dfs(heights, atlantic, rows - 1, col);
        }

        // Atlantic: right column
        for (int row = 0; row < rows; row++) {
            dfs(heights, atlantic, row, cols - 1);
        }

        List<List<Integer>> result = new ArrayList<>();

        // Find cells reachable by both oceans
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (pacific[row][col] && atlantic[row][col]) {
                    result.add(Arrays.asList(row, col));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] ocean,
                     int row, int col) {

        if (ocean[row][col]) {
            return;
        }

        ocean[row][col] = true;

        int[][] directions = {
            {-1, 0}, // up
            {1, 0},  // down
            {0, -1}, // left
            {0, 1}   // right
        };

        for (int[] direction : directions) {

            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow < 0 || newRow >= heights.length ||
                newCol < 0 || newCol >= heights[0].length) {
                continue;
            }

            // Reverse flow:
            // move only to same or higher height
            if (heights[newRow][newCol] < heights[row][col]) {
                continue;
            }

            dfs(heights, ocean, newRow, newCol);
        }
    }
}