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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,0,preorder.length-1);
    }
    public TreeNode helper(int []preorder,int li,int ri){
        if(li>ri) return null;
        
        TreeNode node = new TreeNode(preorder[li]);
        
        int idx = li+1;
        while(idx<=ri && preorder[idx]<preorder[li]) idx++;
        
        node.left = helper(preorder,li+1,idx-1);
        node.right = helper(preorder,idx,ri);
        
        return node;
    }
}