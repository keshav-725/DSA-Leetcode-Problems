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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,postorder,0,inorder.length-1,0,inorder.length-1);
    }
    public TreeNode helper(int []inorder,int []postorder,int li,int ri,int lp,int rp){
        if(li>ri || lp>rp) return null;
        
        TreeNode node = new TreeNode(postorder[rp],null,null);
        
        int i=li;
        while(postorder[rp]!=inorder[i]){
            i++;
        }
        int rem = ri-i;
        node.left = helper(inorder,postorder,li,i-1,lp,rp-rem-1);
        node.right = helper(inorder,postorder,i+1,ri,rp-rem,rp-1);
        
        return node;
    }
}