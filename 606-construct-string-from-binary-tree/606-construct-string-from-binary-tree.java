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
    StringBuilder ans;
    public String tree2str(TreeNode root) {
        ans = new StringBuilder("");
        createTree(root);
        return ans.toString();
    }
    public void createTree(TreeNode root){
        if(root.left==null&&root.right==null){
            ans.append(root.val);
            return;
        }
        ans.append(root.val);
        if(root.left!=null){
            ans.append("(");
            createTree(root.left);
            ans.append(")");
        }
        if(root.left==null&&root.right!=null){
            ans.append("()");
        }
        if(root.right!=null){
            ans.append("(");
            createTree(root.right);
            ans.append(")");
        }
    }
}