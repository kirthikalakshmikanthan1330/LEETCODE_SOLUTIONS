import java.util.*;
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class Solution {
    int preindex=0;
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,0,inorder.length-1);
    }
    TreeNode build(int[] preorder,int left,int right){
        if(left>right){
            return null;
        }
        int rootvalue=preorder[preindex++];
        TreeNode root=new TreeNode(rootvalue);
        int index=map.get(rootvalue);
        root.left=build(preorder,left,index-1);
        root.right=build(preorder,index+1,right);
        return root;
    }
    void printinorder(TreeNode root){
        if(root==null){
            return;
        }
        printinorder(root.left);
        System.out.print(root.val+" ");
        printinorder(root.right);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] preorder=new int[n];
        int[] inorder=new int[n];
        for(int i=0;i<n;i++){
            preorder[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            inorder[i]=sc.nextInt();
        }
        Solution s=new Solution();
        TreeNode root=s.buildTree(preorder,inorder);
        s.printinorder(root);
    }
}