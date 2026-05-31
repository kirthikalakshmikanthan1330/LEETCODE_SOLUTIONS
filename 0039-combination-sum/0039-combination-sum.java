class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        helper(0,candidates,target,new ArrayList<>(),result);
        return result;
    }
    public void helper(int index,int[] nums,int target,List<Integer> curr,List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(target<0||index==nums.length){
            return;
        }
        curr.add(nums[index]);
        helper(index,nums,target-nums[index],curr,result);
        curr.remove(curr.size()-1);
        helper(index+1,nums,target,curr,result);
        }
    }
