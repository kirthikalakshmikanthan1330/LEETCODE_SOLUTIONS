class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        helper(0,nums,new ArrayList<>(),result);
        return result;
    }
    public void helper(int index,int[] nums,List<Integer> curr,List<List<Integer>> result){
        result.add(new ArrayList<>(curr));
        for(int i=index;i<nums.length;i++){
            if(i>index&&nums[i]==nums[i-1]){
                continue;
            }
            curr.add(nums[i]);
            helper(i+1,nums,curr,result);
            curr.remove(curr.size()-1);
        }
    }
}