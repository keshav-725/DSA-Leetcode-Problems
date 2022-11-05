/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = root;
        check(root,p,q);
        return ans;
    }
    public boolean check(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return false;
        
        boolean left = check(root.left,p,q);
        boolean right = check(root.right,p,q);
        
        // System.out.println(root.val+" -> "+left+" -> "+right);
        
        if((left && right) || ((left==true || right==true) && (root==p || root==q))){
            // System.out.println(root.val);
            ans = root;
            return false;
        }
        if(root==p || root==q || left || right) return true;
        return false;
    }
}