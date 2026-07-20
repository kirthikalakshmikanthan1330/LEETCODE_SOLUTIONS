class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int leftmax=0;
        int rightmax=0;
        int units=0;
        while(left<right){
            leftmax=Math.max(leftmax,height[left]);
            rightmax=Math.max(rightmax,height[right]);
            if(leftmax<rightmax){
                int left_1=leftmax-height[left];
                units=units+left_1;
                left++;
            }else{
                int right_1=rightmax-height[right];
                units=units+right_1;
                right--;
            }
        }
        return units;
        
    }
}