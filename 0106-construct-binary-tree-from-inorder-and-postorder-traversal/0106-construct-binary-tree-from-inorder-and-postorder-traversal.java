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
    int posindex;
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        posindex=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(postorder,0,inorder.length-1);
    }
    TreeNode build(int[] postorder,int left,int right){
        if(left>right||posindex<0){
            return null;
        }
        int rootvalue=postorder[posindex];
        posindex--;
        TreeNode root=new TreeNode(rootvalue);
        int index=map.get(rootvalue);
        root.right=build(postorder,index+1,right);
        root.left=build(postorder,left,index-1);
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
        int[] postorder=new int[n];
        int[] inorder=new int[n];
        for(int i=0;i<n;i++){
            postorder[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            inorder[i]=sc.nextInt();
        }
        Solution s=new Solution();
        TreeNode root=s.buildTree(postorder,inorder);
        s.printinorder(root);
    }
}