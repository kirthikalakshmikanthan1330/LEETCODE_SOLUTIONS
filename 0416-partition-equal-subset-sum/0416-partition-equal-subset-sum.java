class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        if(total%2!=0){
            return false;
        }
        int target=total/2;
        boolean[]dp=new boolean[target+1];
        dp[0]=true;
        for(int j=0;j<nums.length;j++){
            for(int k=target;k>=nums[j];k--){
                dp[k]=dp[k]||dp[k-nums[j]];
            }
        }
        return dp[target];
    }
}