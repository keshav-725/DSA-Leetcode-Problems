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
    class Pair{
        int lval;
        TreeNode root;
        Pair(int lval,TreeNode root){
            this.lval = lval;
            this.root = root;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<Pair> queue = new LinkedList<>();
        int maxwidth = Integer.MIN_VALUE;
        int ln = 0,rn=0;
        queue.add(new Pair(0,root));
        while(queue.size()>0){
            int size=queue.size();
            Pair p = queue.getFirst();
            ln = p.lval;
            while(size>0){
                Pair rm = queue.removeFirst();
                if(size==1){
                    rn = rm.lval;
                    maxwidth = Math.max((rn-ln+1),maxwidth);
                }
                if(rm.root.left!=null) queue.addLast(new Pair((rm.lval*2+1),rm.root.left));
                if(rm.root.right!=null) queue.addLast(new Pair((rm.lval*2+2),rm.root.right));
                size--;
            }
        }
        return maxwidth;
    }
}