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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = buildTree_(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        return root;
    }
    public TreeNode buildTree_(int[] preorder, int[] inorder,int pleft,int pright,int ileft,int iright){
        if(pleft>pright || ileft>iright) return null;
        TreeNode root = new TreeNode(preorder[pleft]);
        int center=ileft;
        while(inorder[center]!=preorder[pleft]){
            center++;
        }
        int num = center-ileft;
        root.left = buildTree_(preorder,inorder,pleft+1,pleft+num,ileft,center-1);
        root.right = buildTree_(preorder,inorder,pleft+num+1,pright,center+1,iright);
        
        return root;
    }
}