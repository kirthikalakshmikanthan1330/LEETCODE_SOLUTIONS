class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=0;
        for(int i=0;i<piles.length;i++){
            right=Math.max(right,piles[i]);
        }
        while(left<right){
            int speed=left+(right-left)/2;
            int hours=0;
            for(int i=0;i<piles.length;i++){
                hours+=(piles[i]+speed-1)/speed;
            }
            if(hours<=h){
                right=speed;
            }else{
                left=speed+1;
            }
        }
        return left;
    }
}