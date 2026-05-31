class Solution {
    public String getPermutation(int n, int k) {
        List<String> result=new ArrayList<>();
        boolean[] used=new boolean[n+1];
        helper(n,used,new StringBuilder(),result);
        return result.get(k-1);
    }
    public void helper(int n,boolean[]used,StringBuilder curr,List<String> result){
        if(curr.length()==n){
            result.add(curr.toString());
            return;
        }
        for(int i=1;i<=n;i++){
            if(used[i]==true){
                continue;
            }
            used[i]=true;
            curr.append(i);
            helper(n,used,curr,result);
            curr.deleteCharAt(curr.length()-1);
            used[i]=false;
        }
    }
}