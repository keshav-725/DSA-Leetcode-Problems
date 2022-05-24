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
    public void recoverTree(TreeNode root) {
        TreeNode prev=null,a=null,b=null,curr=root;
        while(curr!=null){
            TreeNode leftnode = curr.left;
            if(leftnode==null){
                if(prev!=null && prev.val>=curr.val){
                    if(a==null) a=prev;
                    b=curr;
                }
                prev = curr;
                curr = curr.right;
            }else{
                while(leftnode.right!=null && leftnode.right!=curr){
                    leftnode = leftnode.right;
                }
                if(leftnode.right==null){
                    leftnode.right=curr;
                    curr = curr.left;
                }else{
                    leftnode.right=null;
                    if(prev!=null && prev.val>=curr.val){
                        if(a==null) a=prev;
                        b=curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        if(a!=null){
            int temp=a.val;
            a.val=b.val;
            b.val=temp;
        }
    }
}