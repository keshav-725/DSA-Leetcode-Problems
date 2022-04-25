/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        nodeToRootPath(root,target,k,ans);
        return ans;
    }
    public int nodeToRootPath(TreeNode root,TreeNode target,int k,List<Integer> ans){
        if(root==null) return -1;
        
        if(root==target){
            printKdown(root,k,null,ans);
            return 1;
        }
        int ld = nodeToRootPath(root.left,target,k,ans);
        if(ld!=-1){
            printKdown(root,k-ld,root.left,ans);
            return ld+1;
        }
        int rd = nodeToRootPath(root.right,target,k,ans);
        if(rd!=-1){
            printKdown(root,k-rd,root.right,ans);
            return rd+1;
        }
        return -1;
    }
    public void printKdown(TreeNode root,int k,TreeNode block,List<Integer> ans){
        if(root==null || k<0 || root==block) return;
        
        if(k==0){
            ans.add(root.val);
            return;
        }
        printKdown(root.left,k-1,block,ans);
        printKdown(root.right,k-1,block,ans);
    }
}