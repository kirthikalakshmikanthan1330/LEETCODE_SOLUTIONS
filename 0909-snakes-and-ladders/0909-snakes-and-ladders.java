class Solution {

    public int snakesAndLadders(int[][] board) {

        int n = board.length;

        boolean[] visited = new boolean[n * n + 1];

        Queue<int[]> queue = new LinkedList<>();

        // {square, moves}
        queue.add(new int[]{1, 0});

        visited[1] = true;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int square = current[0];
            int moves = current[1];

            // Reached the final square
            if (square == n * n) {
                return moves;
            }

            // Try dice values from 1 to 6
            for (int dice = 1; dice <= 6; dice++) {

                int next = square + dice;

                // Cannot go beyond final square
                if (next > n * n) {
                    break;
                }

                // Convert square number to board position
                int quotient = (next - 1) / n;

                int row = n - 1 - quotient;

                int col = (next - 1) % n;

                // Reverse the column for alternate rows
                if (quotient % 2 == 1) {
                    col = n - 1 - col;
                }

                // Snake or ladder
                if (board[row][col] != -1) {
                    next = board[row][col];
                }

                // If not visited, add to queue
                if (!visited[next]) {

                    visited[next] = true;

                    queue.add(new int[]{
                        next,
                        moves + 1
                    });
                }
            }
        }

        return -1;
    }
}