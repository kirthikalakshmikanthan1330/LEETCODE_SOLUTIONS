class Solution {

    public boolean isValidSudoku(char[][] board) {

        // Check every cell
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] != '.') {

                    char num = board[row][col];

                    // Temporarily remove the number
                    board[row][col] = '.';

                    // Check whether this number is valid
                    if (!isValid(board, row, col, num)) {
                        return false;
                    }

                    // Put the number back
                    board[row][col] = num;
                }
            }
        }

        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char num) {

        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Find starting position of 3x3 box
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        // Check 3x3 box
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {

                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}