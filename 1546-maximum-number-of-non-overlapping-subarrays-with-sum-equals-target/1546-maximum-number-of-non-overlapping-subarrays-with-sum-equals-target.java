class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                count++;
                map.clear();
                sum=0;
                map.put(0, i);
            }else{
                map.put(sum, i);
            }
        }
        return count;
    }
}