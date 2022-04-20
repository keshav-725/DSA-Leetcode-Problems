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
    public class Pair{
        int forward=-1;
        int backward=-1;
        int maxlen=0;
    }
    public int longestZigZag(TreeNode root) {
        Pair ans = helper(root);
        return ans.maxlen;
    }
    public Pair helper(TreeNode root){
        if(root==null) return new Pair();
        
        Pair lpair = helper(root.left);
        Pair rpair = helper(root.right);
        
        Pair mp = new Pair();
        mp.maxlen = Math.max(lpair.maxlen,Math.max(rpair.maxlen,Math.max(lpair.backward,rpair.forward)+1));
        mp.forward = lpair.backward+1;
        mp.backward = rpair.forward+1;
        
        return mp;
        
    }
}