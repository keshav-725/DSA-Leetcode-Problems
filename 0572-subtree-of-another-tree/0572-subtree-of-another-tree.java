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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        ans = false;
        helper(root,subRoot);
        return ans;
    }
    public void helper(TreeNode root, TreeNode subRoot){
        if(root==null || subRoot==null) return;
        
        if(root.val==subRoot.val){
            boolean check = helper2(root,subRoot);
            if(check){
                ans = true;
                return;
            }
        }
        helper(root.left,subRoot);
        helper(root.right,subRoot);
    }
    public boolean helper2(TreeNode root, TreeNode subRoot){
        // System.out.println("check");
        if(root==null || subRoot==null){
            if(root==null && subRoot==null) return true;
            else return false;
        }
        // if((root==null &&subRoot==null) || (root != null && subRoot==null)) return true;
        // if(root==null && subRoot != null) return false;
        
        // System.out.println(root.val + " -> " +subRoot.val);
        
        boolean left = helper2(root.left,subRoot.left);
        boolean right = helper2(root.right,subRoot.right);
        
        boolean check = (root.val==subRoot.val);
        
        if(left && right && check) return true;
        
        return false;
    }
}