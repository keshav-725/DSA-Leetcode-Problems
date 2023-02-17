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
    List<Integer> list;
    public int minDiffInBST(TreeNode root) {
        list = new ArrayList<>();
        int ans = Integer.MAX_VALUE;
        dfs(root);
        Collections.sort(list);
        for(int i=1;i<list.size();i++){
            ans = Math.min(ans, list.get(i)-list.get(i-1));
        }
        return ans;
    }
    public void dfs(TreeNode root){
        if(root==null){
            return ;
        }
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }   
}