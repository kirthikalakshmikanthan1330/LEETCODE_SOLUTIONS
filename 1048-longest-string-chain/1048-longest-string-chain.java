class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        HashMap<String,Integer> map=new HashMap<>();
        int ans=1;
        for(int i=0;i<words.length;i++){
            String word=words[i];
            int best=1;
            for(int j=0;j<word.length();j++){
                String prev=word.substring(0,j)+word.substring(j+1);
                if(map.containsKey(prev)){
                    best=Math.max(best,map.get(prev)+1);
                }
            }
            map.put(word,best);
            ans=Math.max(ans,best);
        }
        return ans;
    }
}