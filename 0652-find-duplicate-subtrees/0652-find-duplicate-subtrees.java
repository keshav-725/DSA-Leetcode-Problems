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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        
        helper(root,map,ans);
        
        return ans;
    }
    public String helper(TreeNode root,HashMap<String,Integer> map,List<TreeNode> ans){
        if(root==null) return "*";
        String left = helper(root.left,map,ans);
        String right = helper(root.right,map,ans);
        
        String str = left + "," + right + "," + root.val;
        
        map.put(str,map.getOrDefault(str,0)+1);
        
        if(map.get(str)==2){
            ans.add(root);
        }
        return str;
    }
}