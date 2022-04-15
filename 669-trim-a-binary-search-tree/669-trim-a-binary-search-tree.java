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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return helper(root,low,high);
    }
    public TreeNode helper(TreeNode root, int low, int high){
        if(root==null) return null;
        
        if(root.val<low){
            root.left = null;
        }else if(root.val>high){
            root.right = null;
        }
        
        TreeNode rleft = helper(root.left,low,high);
        TreeNode rright = helper(root.right,low,high);
        
        root.left = rleft;
        root.right = rright;
        
        if(root.val<low){
            return rright;
        }
        else if(root.val>high){
            return rleft;
        }
        
        return root;
    }
}