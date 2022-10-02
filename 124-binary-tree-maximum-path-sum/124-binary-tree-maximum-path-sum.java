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
    static int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }
    public int helper(TreeNode root){
        if(root==null) return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int tmax = Math.max(0,Math.max(left,right));
        max = Math.max(max,Math.max(Math.max(root.val+right,root.val+left),Math.max(root.val,root.val+left+right)));
        
        return tmax+root.val;
    }
}