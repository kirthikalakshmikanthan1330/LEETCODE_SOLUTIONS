class Solution {
    public String longestPalindrome(String s) {
        String ans=" ";
        for(int i=0;i<s.length();i++){
            if(expand(s,i,i).length()>ans.length()-1){
                ans=expand(s,i,i);
            }
        }
        for(int i=0;i<s.length();i++){
            if(expand(s,i,i+1).length()>ans.length()){
                ans=expand(s,i,i+1);
            }
        }
        return ans;  
    }
    public String expand(String A,int L,int R){
        while(L>=0 && R<A.length()&& A.charAt(L)==A.charAt(R)){
            L--;
            R++;
        }
        return A.substring(L+1,R);
    }
}