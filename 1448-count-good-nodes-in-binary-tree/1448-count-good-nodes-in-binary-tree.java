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
    int ans;
    public int goodNodes(TreeNode root) {
        ans=0;
        helper(root,root.val);
        return ans;
    }
    public void helper(TreeNode root,int max){
        if(root==null) return;
        
        if(max<=root.val) ans++;
        
        int temp = Math.max(root.val,max);
        
        helper(root.left,temp);
        helper(root.right,temp);
        
    }
}