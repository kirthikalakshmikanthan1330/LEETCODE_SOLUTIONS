class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<board.length;i++){
            Arrays.fill(board[i],'.');
        }
        backtrack(0,board,result);
        return result;
    }
    public void backtrack(int row,char[][] board,List<List<String>> result){
        if(row==board.length){
            List<String> curr=new ArrayList<>();
            for(int j=0;j<board.length;j++){
                curr.add(new String(board[j]));
            }
            result.add(curr);
            return;
        }
        for(int col=0;col<board.length;col++){
            if(isSafe(row,col,board)){
                board[row][col]='Q';
                backtrack(row+1,board,result);
                board[row][col]='.';
            }
        }
    }
    public boolean isSafe(int row, int col, char[][] board){
    // Check same column
    for(int i = 0; i < row; i++){
        if(board[i][col] == 'Q'){
            return false;
        }
    }
    // Check upper-left diagonal
    for(int i = row - 1, j = col - 1;
        i >= 0 && j >= 0;
        i--, j--){
        if(board[i][j] == 'Q'){
            return false;
        }
    }
    // Check upper-right diagonal
    for(int i = row - 1, j = col + 1;
        i >= 0 && j < board.length;
        i--, j++){
        if(board[i][j] == 'Q'){
            return false;
        }
    }
    return true;
}
}