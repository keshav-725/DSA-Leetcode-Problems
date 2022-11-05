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
    boolean ans;
    public boolean isValidBST(TreeNode root) {
        ans = true;
        helper(root);
        return ans;
    }
    public long[] helper(TreeNode root){
        if(root==null){
            long []ret = new long[2];
            ret[0]=Long.MAX_VALUE;
            ret[1]=Long.MIN_VALUE;
            return ret;
        }
        
        long []left = helper(root.left);
        long []right = helper(root.right);
        
        if(left[1]>=root.val || right[0]<=root.val) ans=false;
        
        long []res = new long[2];
        
        res[0] = left[0]==Long.MAX_VALUE ? root.val : left[0];
        res[1] = right[1] == Long.MIN_VALUE ? root.val : right[1];
        
        return res;
    }
}