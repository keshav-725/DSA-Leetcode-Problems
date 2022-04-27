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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root,targetSum,0);
    }
    public boolean helper(TreeNode root, int targetSum,int psfsum){
        if(root==null) return false;
        if(root.left==null&&root.right==null && targetSum==psfsum+root.val){
            return true;
        }
        boolean lside = helper(root.left,targetSum,psfsum+root.val);
        if(lside==true) return true;
        boolean rside = helper(root.right,targetSum,psfsum+root.val);
        if(rside==true) return true;
        return false;
    }
}