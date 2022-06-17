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
    public int count =0;

    public int minCameraCover(TreeNode root) {
        int value = helper(root);
        if(value==-1) count++;
        return count;
    }
    public int helper(TreeNode root){
        if(root==null) return 1;
        
        int lval = helper(root.left);
        int rval = helper(root.right);
        
        if(lval==-1 || rval==-1){
            count++;
            return 0;
        }
        else if(lval==0 || rval==0){
            return 1;
        }
        return -1;   
    }
    
}