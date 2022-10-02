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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root==null) return ans;
        queue.addLast(root);
        while(queue.size()>0){
            int size=queue.size();
            List<Integer> list = new ArrayList<>();
            while(size-->0){
                TreeNode rem = queue.removeFirst();
                list.add(rem.val);
                if(rem.left!=null) queue.addLast(rem.left);
                if(rem.right!=null) queue.addLast(rem.right);
            }
            ans.add(0,new ArrayList<>(list));
        }
        return ans;
    }
}