class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0;
        int right=0;
        for(int i=0;i<weights.length;i++){
            left=Math.max(left,weights[i]);
            right=right+weights[i];
        }
        while(left<right){
            int capacity=left+(right-left)/2;
            int daysused=1;
            int currentweight=0;
            for(int i=0;i<weights.length;i++){
                if(currentweight+weights[i]>capacity){
                    daysused++;
                    currentweight=weights[i];
                }else{
                    currentweight+=weights[i];
                }
            }
            if(daysused<=days){
                right=capacity;
            }else{
                left=capacity+1;
            }
        }
        return left;
    }
}