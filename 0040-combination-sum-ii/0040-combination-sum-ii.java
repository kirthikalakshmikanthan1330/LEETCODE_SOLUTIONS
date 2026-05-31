class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        helper(0,candidates,target,new ArrayList<>(),result);
        return result;
    }
    public void helper(int index,int[] nums,int target,List<Integer> curr,List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(i>index&&nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]>target){
                break;
            }
            curr.add(nums[i]);
            helper(i+1,nums,target-nums[i],curr,result);
            curr.remove(curr.size()-1);
        }
    }
 }
