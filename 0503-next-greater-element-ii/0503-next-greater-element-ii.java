import java.util.*;
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int current = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < current) {
                int index = stack.pop();
                answer[index] = current;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return answer;
    }
}