class Solution {
    public int longestOnes(int[] nums, int k) {

        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            int zeros = 0;
            int count = 0;

            for (int j = i; j < nums.length; j++) {

                if (nums[j] == 0) {
                    zeros++;
                }

                if (zeros > k) {
                    break;
                }

                count++;
                max = Math.max(max, count);
            }
        }

        return max;
    }
}