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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,inorder.length-1,0,inorder.length-1);
    }
    public TreeNode helper(int[] preorder, int[] inorder,int li,int ri,int lp,int rp){
        if(li>ri || lp>rp) return null;
        
        TreeNode node = new TreeNode(preorder[lp],null,null);
        int i=li,count=0;
        for(;i<=ri;i++){
            if(preorder[lp]==inorder[i]) break;
            count++;
        }
        node.left = helper(preorder,inorder,li,i,lp+1,lp+count);
        node.right = helper(preorder,inorder,i+1,ri,lp+count+1,rp);
        return node;
    }
}