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
    int count;
    public int pathSum(TreeNode root, int targetSum) {
        ArrayList<TreeNode> list = new ArrayList<>();
        getAllNode(root,list);
        count=0;
        for(int i=0;i<list.size();i++){
            travel2(list.get(i),0,targetSum);
        }
        return count;
    }
    public void travel2(TreeNode root,long sum,int tsum){
        if(root==null) return;
        
        if(sum + root.val==tsum){
            count++;
        }
        travel2(root.left,sum+root.val,tsum);
        travel2(root.right,sum+root.val,tsum);
        
    }
    public void getAllNode(TreeNode root,ArrayList<TreeNode> list){
        if(root==null) return;
        
        list.add(root);
        getAllNode(root.left,list);
        getAllNode(root.right,list);
    }
}