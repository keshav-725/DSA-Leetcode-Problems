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
    boolean check;
    public boolean isValidBST(TreeNode root) {
        check=true;
        helper(root);
        return check;
    }
    public long[] helper(TreeNode root){
        if(root==null) return new long[]{Long.MAX_VALUE,Long.MIN_VALUE};
        
        long[] left = helper(root.left);
        long[] right = helper(root.right);
        
        if(left[1]>=root.val || right[0]<=root.val) check=false;
        
        long lmin = Math.min(left[0],root.val);
        long rmax = Math.max(right[1],root.val);
        
        return new long[]{lmin,rmax};
    }
}