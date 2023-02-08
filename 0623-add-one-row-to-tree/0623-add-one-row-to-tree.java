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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        helper(root,val,depth);
        return root;
    }
    public void helper(TreeNode root,int val,int depth){
        if(root==null) return;
        if(depth<2) return;
        if(depth ==2){
            TreeNode lnode = new TreeNode(val);
            TreeNode rnode = new TreeNode(val);
            
            lnode.left = root.left;
            rnode.right = root.right;
            
            root.left = lnode;
            root.right = rnode;
            
            return;
        }
        helper(root.left,val,depth-1);
        helper(root.right,val,depth-1);
    }
}