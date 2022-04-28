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
        addOneRow_(root,val,depth);
        return root;
    }
    public void addOneRow_(TreeNode root, int val, int depth){
        if(root==null) return;
        if(depth==2){
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);
            
            TreeNode tleft=root.left;
            TreeNode tright = root.right;
            
            root.left = left;
            root.right = right;
            
            left.left=tleft;
            right.right = tright;
        }   
        else{
            addOneRow_(root.left,val,depth-1);
            addOneRow_(root.right,val,depth-1);
        }
    }
}