class Solution {
    public int minSteps(String s, String t) {
        int[] freq=new int[26];
        char[] a=s.toCharArray();
        char[] b=t.toCharArray();
        for(int i=0;i<a.length;i++){
            freq[a[i]-'a']++;
        }
        for(int j=0;j<b.length;j++){
            freq[b[j]-'a']--;
        }
        int steps=0;
        for(int k=0;k<freq.length;k++){
            steps+=Math.abs(freq[k]);
        }
        return steps;
    }
}