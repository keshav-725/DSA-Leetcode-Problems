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
        rightSideView_(root,ans,0);
        return ans;
    }
    public void rightSideView_(TreeNode root,List<Integer> list,int level){
        if(root==null) return;
        if(level==list.size()) list.add(root.val);
        rightSideView_(root.right,list,level+1);
        rightSideView_(root.left,list,level+1);
    }
}