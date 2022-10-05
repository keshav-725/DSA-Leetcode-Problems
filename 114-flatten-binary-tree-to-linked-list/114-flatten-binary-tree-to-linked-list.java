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
    public void flatten(TreeNode root) {
        helper(root);
    }
    public TreeNode helper(TreeNode root){
        if(root==null) return null;
        
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        
        root.left = null;
        root.right = left;
        if(left!=null){
            while(left.right!=null) left = left.right;
            left.right = right;
        }
        else root.right=right;
        
        return root;
    }
}