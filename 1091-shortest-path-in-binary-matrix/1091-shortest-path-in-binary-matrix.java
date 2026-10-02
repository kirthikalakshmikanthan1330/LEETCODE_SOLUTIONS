class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        // Start or destination is blocked
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        // 8 possible directions
        int[][] directions = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}
        };

        Queue<int[]> queue = new LinkedList<>();

        // row, column, distance
        queue.add(new int[]{0, 0, 1});

        grid[0][0] = 1;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int distance = current[2];

            // Reached destination
            if (row == n - 1 && col == n - 1) {
                return distance;
            }

            // Check all 8 directions
            for (int i = 0; i < 8; i++) {

                int newRow = row + directions[i][0];
                int newCol = col + directions[i][1];

                // Check whether the new cell is valid
                if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < n &&
                    grid[newRow][newCol] == 0) {

                    // Mark as visited
                    grid[newRow][newCol] = 1;

                    // Add to queue with distance + 1
                    queue.add(new int[]{
                        newRow,
                        newCol,
                        distance + 1
                    });
                }
            }
        }

        // No path exists
        return -1;
    }
}