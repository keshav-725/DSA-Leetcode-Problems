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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder,postorder,0,preorder.length-1,0,preorder.length-1);
    }
    public TreeNode helper(int[] preorder,int []postorder,int prs,int pre,int pos,int poe){
        if(prs>pre || pos>poe) return null;
        TreeNode node = new TreeNode(preorder[prs]);
        if(prs==pre) return node;
        int nxt = preorder[prs+1],i=pos;
        while(postorder[i]!=nxt){
            i++;
        }
        int count = i-pos+1;
        node.left = helper(preorder,postorder,prs+1,prs+count,pos,i);
        node.right = helper(preorder,postorder,prs+count+1,pre,pos+count,poe-1);
        
        return node;
    }
}