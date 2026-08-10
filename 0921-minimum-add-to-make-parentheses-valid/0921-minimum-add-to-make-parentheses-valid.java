class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack=new Stack<>();
        char[]c=s.toCharArray();
        int count=0;
        for(int i=0;i<c.length;i++){
            if(c[i]=='('){
                stack.push(c[i]);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    count++;
                }
            }
        }
       count+=stack.size(); 
        return count;
    }
   
}