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
    public boolean isValidBST(TreeNode root) {
        TreeNode curr = root,prev = null;
        
        while(curr!=null){
            if(curr.left==null){
                if(prev!=null && prev.val>=curr.val) return false;
                prev=curr;
                curr = curr.right;
            }    
            else{
                TreeNode ln = curr.left;
                while(ln.right!=null && ln.right!=curr){
                    ln = ln.right;
                }
                if(ln.right==null){
                    ln.right = curr;
                    curr = curr.left;
                }else{
                    if(prev!=null && prev.val>=curr.val) return false;
                    prev = curr;
                    ln.right=null;
                    curr = curr.right;
                }
            }
        }
        return true;
    }
}