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
    public boolean isEvenOddTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        int count = 0;
        queue.add(root);
        int potnum;
        while(queue.size()>0){
            count++;
            if(count%2==0){
                potnum = Integer.MAX_VALUE;
            }else{
                potnum = Integer.MIN_VALUE;
            }
            int size=queue.size();
            while(size-->0){
                TreeNode rm = queue.removeFirst();
                if(count%2==0){
                    if(rm.val>=potnum || rm.val%2!=0) return false;
                    potnum = rm.val;
                }else{
                    if(rm.val<=potnum || rm.val%2==0) return false;
                    potnum = rm.val;
                }
                if(rm.left!=null) queue.addLast(rm.left);
                if(rm.right!=null) queue.addLast(rm.right);
            }
        }
        return true;
    }
}