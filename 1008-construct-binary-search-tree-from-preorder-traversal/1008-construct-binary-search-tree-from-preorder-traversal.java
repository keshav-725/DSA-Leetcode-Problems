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
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder_(preorder,0,preorder.length-1);
    }
    public TreeNode bstFromPreorder_(int []preorder,int si,int ei){
        if(si>ei) return null;
        TreeNode root = new TreeNode(preorder[si]);
        
        int num = preorder[si];
        int n = si+1;
        while(n<=ei && num>preorder[n]) n++;
        
        int count = n-si;
        root.left = bstFromPreorder_(preorder,si+1,si+count-1);
        root.right = bstFromPreorder_(preorder,si+count,ei);
        
        return root;
    }
}