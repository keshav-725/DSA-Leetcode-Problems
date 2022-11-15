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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int left = 0;
        TreeNode tnode = root.left;
        while(tnode!=null){
            tnode=tnode.left;
            left++;
        }
        int right = 0;
        tnode = root.right;
        while(tnode!=null){
            tnode=tnode.right;
            right++;
        }
        
        if(left==right){
            left++;
            return (1<<left)-1;
        }
        return countNodes(root.left)+countNodes(root.right)+1;
        
    }
}