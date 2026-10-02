class Solution {

    public int maxDistance(int[][] grid) {

        int n = grid.length;

        Queue<int[]> queue = new LinkedList<>();

        int landCount = 0;

        // Add all land cells to the queue
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {

                    queue.add(new int[]{i, j, 0});

                    landCount++;
                }
            }
        }

        // All land or all water
        if (landCount == 0 || landCount == n * n) {
            return -1;
        }

        int[][] directions = {
            {-1, 0},  // up
            {1, 0},   // down
            {0, -1},  // left
            {0, 1}    // right
        };

        int answer = 0;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int distance = current[2];

            answer = distance;

            for (int i = 0; i < 4; i++) {

                int newRow = row + directions[i][0];
                int newCol = col + directions[i][1];

                if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < n &&
                    grid[newRow][newCol] == 0) {

                    // Mark as visited
                    grid[newRow][newCol] = 1;

                    queue.add(new int[]{
                        newRow,
                        newCol,
                        distance + 1
                    });
                }
            }
        }

        return answer;
    }
}