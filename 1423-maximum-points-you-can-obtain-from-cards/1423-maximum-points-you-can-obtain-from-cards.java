class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int total=0;
        for(int i=0;i<n;i++){
            total=total+cardPoints[i];
        }
        int window=n-k;
        int sum=0;
        int minimum=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum=sum+cardPoints[i];
            if(i>=window){
                sum=sum-cardPoints[i-window];
            }
            if(i>=window-1){
                minimum=Math.min(minimum,sum);
            }
        }
        int answer=0;
        return answer+=total-minimum;
    }
}