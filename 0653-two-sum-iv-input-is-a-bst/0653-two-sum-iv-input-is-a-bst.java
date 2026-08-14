/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> ans=new ArrayList<>();
        TreeValuesInList(root,ans);
        Collections.sort(ans);
        int left=0;
        int right=ans.size()-1;
        while(left<right){
            int sum=ans.get(left)+ans.get(right);
            if(sum==k){
                return true;
            }else if(sum<k){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
    public void  TreeValuesInList(TreeNode root,List<Integer> ans){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            ans.add(curr.val);
            if(curr.left!=null){
                q.offer(curr.left);
            }
            if(curr.right!=null){
                q.offer(curr.right);
            }
        }
    }
}