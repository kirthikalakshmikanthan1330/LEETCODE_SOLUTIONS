class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
       List<Integer> result=new ArrayList<>();
       for(int start=1;start<=9;start++){
        int num=start;
        int next=start+1;
        while(next<=9){
            num=num*10+next;
            if(num>=low&&num<=high){
                result.add(num);
            }
            if(num>high){
                break;
            }
            next++;
        }
       }
       Collections.sort(result);
       return result; 
    }
}