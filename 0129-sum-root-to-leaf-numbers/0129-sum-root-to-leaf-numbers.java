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
    int sum;
    public int sumNumbers(TreeNode root) {
        sum=0;
        helper(root,0);
        return sum;
    }
    public void helper(TreeNode root,int temp){
        if(root==null) return;
        temp = temp * 10 + root.val;
        // System.out.println(temp);
        if(root.left==null && root.right==null){
            sum += temp;
        }
        helper(root.left,temp);
        helper(root.right,temp);
    }
}