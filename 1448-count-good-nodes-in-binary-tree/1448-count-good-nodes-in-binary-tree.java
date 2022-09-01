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
    private int count=0;
    public int goodNodes(TreeNode root) {
        goodNodes(root,root.val);
        return count;
    }
    public void goodNodes(TreeNode root,int max){
        if(root==null) return;
        int temp = Math.max(root.val,max);
        if(temp<=root.val){
            count++;   
        }
        goodNodes(root.left,temp);
        goodNodes(root.right,temp);
    }
}