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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        helper(root,targetSum,0,ans,res);
        return ans;
    }
    public void helper(TreeNode root, int targetSum,int psfsum,List<List<Integer>> ans,List<Integer> res){
        if(root==null) return;
        res.add(root.val);
        if(root.left==null && root.right==null && targetSum==psfsum+root.val){
            ans.add(new ArrayList<>(res));
        }
        else{
            helper(root.left,targetSum,psfsum+root.val,ans,res);
            helper(root.right,targetSum,psfsum+root.val,ans,res);
        }
        res.remove(res.size()-1);
    }
}