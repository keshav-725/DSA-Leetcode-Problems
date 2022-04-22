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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(queue.size()>0){
            int size=queue.size();
            ans.add(queue.getFirst().val);
            while(size-->0){
                TreeNode rem = queue.removeFirst();
                if(rem.right!=null) queue.addLast(rem.right);
                if(rem.left!=null) queue.addLast(rem.left);
            }
        }
        return ans;
    }
}