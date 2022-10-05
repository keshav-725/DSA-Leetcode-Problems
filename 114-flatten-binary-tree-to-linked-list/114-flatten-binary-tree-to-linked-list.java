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
    TreeNode prev;
    public void flatten(TreeNode root) {
        prev = null;
        helper(root);
    }
    public void helper(TreeNode root){
        if(root==null) return;
        
        TreeNode ol= root.left;
        TreeNode or = root.right;
        
        if(prev!=null){
            prev.left=null;
            prev.right=root;
        }
        
        prev= root;
        helper(ol);
        helper(or);
    }
}