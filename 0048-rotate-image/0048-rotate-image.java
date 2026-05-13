class Solution {
    public void rotate(int[][] matrix) {
        int n =matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                trans(matrix,i,j);
            }
        }
        for(int i=0;i<n;i++){
            int start=0;
            int end=n-1;
            while(start<end){
                swap(matrix,i,start,end);
                start++;
                end--;
            }
        }
    }
    public void trans(int[][]matrix,int i,int j){
            int temp=matrix[i][j];
            matrix[i][j]=matrix[j][i];
            matrix[j][i]=temp;
        }
        public void swap(int[][] matrix,int i,int start,int end){
            int temp=matrix[i][start];
            matrix[i][start]=matrix[i][end];
            matrix[i][end]=temp;
        }
}