class Solution {

    public int shortestBridge(int[][] grid) {

        int n = grid.length;

        Queue<int[]> queue = new LinkedList<>();

        boolean found = false;

        // Step 1: Find the first island
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {

                    dfs(grid, i, j, queue);

                    found = true;
                    break;
                }
            }

            if (found) {
                break;
            }
        }

        // Step 2: BFS from the first island
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];

                for (int j = 0; j < 4; j++) {

                    int newRow = row + directions[j][0];
                    int newCol = col + directions[j][1];

                    if (newRow >= 0 && newRow < n &&
                        newCol >= 0 && newCol < n) {

                        // Reached second island
                        if (grid[newRow][newCol] == 1) {
                            return distance;
                        }

                        // Expand through water
                        if (grid[newRow][newCol] == 0) {

                            grid[newRow][newCol] = 2;

                            queue.add(new int[]{
                                newRow,
                                newCol
                            });
                        }
                    }
                }
            }

            distance++;
        }

        return -1;
    }

    // DFS to mark the complete first island
    public void dfs(int[][] grid,
                    int row,
                    int col,
                    Queue<int[]> queue) {

        int n = grid.length;

        if (row < 0 || row >= n ||
            col < 0 || col >= n ||
            grid[row][col] != 1) {

            return;
        }

        // Mark first island
        grid[row][col] = 2;

        // Add island cell to BFS queue
        queue.add(new int[]{row, col});

        dfs(grid, row - 1, col, queue);
        dfs(grid, row + 1, col, queue);
        dfs(grid, row, col - 1, queue);
        dfs(grid, row, col + 1, queue);
    }
}