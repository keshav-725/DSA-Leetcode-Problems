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
    public List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }
    public List<TreeNode> helper(int st,int en){
        if(st>en){
            List<TreeNode> bres = new ArrayList<>();
            bres.add(null);
            return bres;
        }
        List<TreeNode> ans = new ArrayList<>();
        for(int i=st;i<=en;i++){
            
            List<TreeNode> left = helper(st,i-1);
            List<TreeNode> right = helper(i+1,en);
            
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    ans.add(node);
                }
            }
        }
        return ans;
    }
}