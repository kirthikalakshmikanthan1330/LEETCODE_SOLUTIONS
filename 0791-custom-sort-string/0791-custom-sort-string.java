class Solution {
    public String customSortString(String order, String s) {
        int[] freq=new int[26];
        char[] a=order.toCharArray();
        char[]b=s.toCharArray();
        for(int i=0;i<b.length;i++){
            freq[b[i]-'a']++;
        }
        String result="";
        for(int j=0;j<a.length;j++){
            while(freq[a[j]-'a']>0){
                result+=a[j];
                freq[a[j]-'a']--;
            }
        }
        for(int k=0;k<freq.length;k++){
            while(freq[k]>0){
                result=result+(char)(k+'a');
                freq[k]--;
            }
        }
        return result;
    }
}