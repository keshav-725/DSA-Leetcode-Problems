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
    int ans;
    public int goodNodes(TreeNode root) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        ans=0;
        helper(root,pq);
        return ++ans;
    }
    public void helper(TreeNode root,PriorityQueue<Integer> pq){
        if(root==null) return;
        
        if(pq.size()>0 && pq.peek()<=root.val) ans++;
        pq.add(root.val);
        
        helper(root.left,pq);
        helper(root.right,pq);
        
        pq.remove(root.val);
    }
}