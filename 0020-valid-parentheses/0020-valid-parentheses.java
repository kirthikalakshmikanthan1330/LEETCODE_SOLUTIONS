class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        char [] c=c=s.toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]=='('||c[i]=='{'||c[i]=='['){
                stack.push(c[i]);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char top=stack.pop();
                if((c[i]==')'&&top!='(')||(c[i]=='}'&&top!='{')||(c[i]==']'&&top!='[')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}