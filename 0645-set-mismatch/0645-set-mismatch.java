import java.util.*;
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] result = new int[2];
        for (int j = 0; j < n; j++) {
            int value = nums[j];
            count[value - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (count[i] == 2) {
                result[0] = i + 1; 
            }
            if (count[i] == 0) {
                result[1] = i + 1; 
            }
        }
        return result;
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        Solution obj = new Solution();
        int[] b = obj.findErrorNums(arr);
        System.out.println("Duplicate: " + b[0]);
        System.out.println("Missing: " + b[1]);
    }
}
