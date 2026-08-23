class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> a=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                a.add(nums[i]);
            }
        }
        int k=1;
        while(a.contains(k)){
            k++;
        }
        return k;
    }
}