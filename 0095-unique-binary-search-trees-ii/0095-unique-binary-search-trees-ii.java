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
    public List<TreeNode> generateTrees(int n) {
        return generate(1,n);
    }
    public List<TreeNode> generate(int start,int end){
        List<TreeNode> result=new ArrayList<>();
        if(start>end){
            result.add(null);
            return result;
        }
        for(int root=start;root<=end;root++){
            List<TreeNode> leftTree=generate(start,root-1);
            List<TreeNode> rightTree=generate(root+1,end);
            for(int i=0;i<leftTree.size();i++){
                for(int j=0;j<rightTree.size();j++){
                    TreeNode node=new TreeNode(root);
                    node.left=leftTree.get(i);
                    node.right=rightTree.get(j);
                    result.add(node);
                }
            }
        }
        return result;
    }
}