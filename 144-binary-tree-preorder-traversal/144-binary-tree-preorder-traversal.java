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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left==null){
                ans.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode ln = curr.left;
                while(ln.right!=null && ln.right!=curr) ln = ln.right;
                if(ln.right==null){
                    ans.add(curr.val);
                    ln.right=curr;
                    curr = curr.left;
                }else{
                    ln.right = null;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
}