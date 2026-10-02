class Solution {

    public int shortestPath(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // {row, col, obstaclesUsed, distance}
        queue.add(new int[]{0, 0, 0, 0});

        // visited[row][col][obstaclesUsed]
        boolean[][][] visited = new boolean[m][n][k + 1];

        visited[0][0][0] = true;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int obstaclesUsed = current[2];
            int distance = current[3];

            // Reached destination
            if (row == m - 1 && col == n - 1) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {

                int newRow = row + directions[i][0];
                int newCol = col + directions[i][1];

                if (newRow >= 0 && newRow < m &&
                    newCol >= 0 && newCol < n) {

                    int newObstaclesUsed = obstaclesUsed;

                    // If next cell is an obstacle
                    if (grid[newRow][newCol] == 1) {
                        newObstaclesUsed++;
                    }

                    // We still have elimination available
                    if (newObstaclesUsed <= k &&
                        !visited[newRow][newCol][newObstaclesUsed]) {

                        visited[newRow][newCol][newObstaclesUsed] = true;

                        queue.add(new int[]{
                            newRow,
                            newCol,
                            newObstaclesUsed,
                            distance + 1
                        });
                    }
                }
            }
        }

        return -1;
    }
}