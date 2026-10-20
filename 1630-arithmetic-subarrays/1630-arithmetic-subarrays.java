class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> answer=new ArrayList<>();
        for(int i=0;i<l.length;i++){
            int start=l[i];
            int end=r[i];
            int size=end-start+1;
            int[] arr=new int[size];
            int index=0;
            for(int j=start;j<=end;j++){
                arr[index]=nums[j];
                index++;
            }
            Arrays.sort(arr);
            int diff=arr[1]-arr[0];
            boolean isarthmetic=true;
            for(int j=2;j<arr.length;j++){
                if(arr[j]-arr[j-1]!=diff){
                    isarthmetic=false;
                    break;
                }
            }
            answer.add(isarthmetic);
        }
        return answer;
    }
}