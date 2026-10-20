class Solution {
    public String removeKdigits(String num, int k) {
        if(k==num.length()){
            return "0";
        }
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<num.length();i++){
            char current=num.charAt(i);
            while(!stack.isEmpty()&&k>0&&stack.peek()>current){
                stack.pop();
                k--;
            }
            stack.push(current);
        }
        //If some k removals are still left, remove them from the end.
        while(k>0){
            stack.pop();
            k--;
        }
        StringBuilder result=new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        result.reverse();
        while(result.length()>1&&result.charAt(0)=='0'){
            result.deleteCharAt(0);
        }
        return result.toString();
    }
}