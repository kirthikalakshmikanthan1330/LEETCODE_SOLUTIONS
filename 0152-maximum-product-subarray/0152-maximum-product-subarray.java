class Solution {
    public int maxProduct(int[] nums) {
        int maxprod=nums[0];
        int minprod=nums[0];
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            int tempmax=Math.max(nums[i],Math.max(maxprod*nums[i],minprod*nums[i]));
            int tempmin=Math.min(nums[i],Math.min(maxprod*nums[i],minprod*nums[i]));
            maxprod=tempmax;
            minprod=tempmin;
            ans=Math.max(ans,maxprod);
        }
        return ans;
    }
}