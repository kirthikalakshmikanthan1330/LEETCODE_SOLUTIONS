import java.util.*;
class KthLargest {
    ArrayList<Integer> list = new ArrayList<>();
    int kth;
    public KthLargest(int k, int[] nums) {
        kth=k;
        for(int i=0;i<nums.length;i++) {
            list.add(nums[i]);
        }
    }
    public int add(int val) {
        list.add(val);
        Collections.sort(list);
        return list.get(list.size() - kth);
    }
}
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */