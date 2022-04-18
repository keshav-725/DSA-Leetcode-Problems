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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        queue.add(root);
        while(queue.size()>0){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            
            while(size-->0){
                TreeNode remove = queue.remove();
                if(remove.left!=null) queue.add(remove.left);
                if(remove.right!=null) queue.add(remove.right);
                list.add(remove.val);  
            }
            ans.add(list);
        }
        return ans;
    }
}