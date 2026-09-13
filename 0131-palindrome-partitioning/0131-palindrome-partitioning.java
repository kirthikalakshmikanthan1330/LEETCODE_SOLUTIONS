class Solution {
    public List<List<String>> partition(String s) {
       List<List<String>> result=new ArrayList<>();
       List<String> current=new ArrayList<>();
       solve(s,0,current,result);
       return result; 
    }
    void solve(String s,int start,List<String> current,List<List<String>> result){
        if(start==s.length()){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=start;i<s.length();i++){
            String sub=s.substring(start,i+1);
            if(isPalindrome(sub)){
                current.add(sub);
                solve(s,i+1,current,result);
                current.remove(current.size()-1);
            }
        }
    }
    boolean isPalindrome(String s){
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}