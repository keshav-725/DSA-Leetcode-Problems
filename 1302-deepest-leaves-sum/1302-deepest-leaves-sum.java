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
    public int deepestLeavesSum(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ans= new ArrayList<>();
        queue.add(root);
        int level = 0;
        while(queue.size()>0){
            ans = new ArrayList<>();
            int size=queue.size();
            while(size-->0){
                TreeNode rm = queue.removeFirst();
                ans.add(rm.val);
                if(rm.left!=null) queue.addLast(rm.left);
                if(rm.right!=null) queue.addLast(rm.right);
            }
        }
        int res = 0;
        for(int i=0;i<ans.size();i++){
            res+=ans.get(i);
        }
        return res;
    }
}