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
        TreeNode prev=null,curr=root,a=null,b=null;
        while(curr!=null){
            if(curr.left==null){
                if(prev!=null && prev.val>curr.val){
                    if(a==null) a=prev;
                    b=curr;
                }
                prev = curr;
                curr = curr.right;
            }else{
                TreeNode ln = curr.left;
                while(ln.right!=null && ln.right!=curr) ln=ln.right;
                if(ln.right==null){
                    ln.right = curr;
                    curr = curr.left;
                }else{
                    if(prev!=null && prev.val>curr.val){
                        if(a==null) a=prev;
                        b=curr;
                    }
                    ln.right=null;
                    prev=curr;
                    curr = curr.right;
                }
            }
        }
        if(a!=null){
            int temp = a.val;
            a.val = b.val;
            b.val=temp;
        }
    }
}