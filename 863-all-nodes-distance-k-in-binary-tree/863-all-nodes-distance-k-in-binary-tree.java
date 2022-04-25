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
        List<TreeNode> list = new ArrayList<>();
        boolean nodeExist = nodeToRootPath(root,target,list);
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            TreeNode block;
            if(i==0){
                block = null;
            }else{
                block = list.get(i-1);
            }
            printKdown(list.get(i),k-i,block,ans);
        }
        return ans;
    }
    public boolean nodeToRootPath(TreeNode root,TreeNode target,List<TreeNode> list){
        if(root==null) return false;
        
        if(root==target){
            list.add(root);
            return true;
        }
        boolean checkleft = nodeToRootPath(root.left,target,list);
        if(checkleft==true){
            list.add(root);
            return true;
        }
        boolean checkright = nodeToRootPath(root.right,target,list);
        if(checkright==true){
            list.add(root);
            return true;
        }
        return false;
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