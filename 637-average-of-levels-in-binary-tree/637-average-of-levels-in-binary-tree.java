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
    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Double> ans = new ArrayList<>();
        queue.add(root);
        while(queue.size()>0){
            int size = queue.size();
            double sum = 0;
            int total = size;
            while(size-->0){
                TreeNode rem = queue.removeFirst();
                sum += rem.val;
                if(rem.left!=null) queue.addLast(rem.left);
                if(rem.right!=null) queue.addLast(rem.right);
            }
            double avg = (sum*1.0)/total;
            ans.add(avg);
        }
        return ans;
    }
}