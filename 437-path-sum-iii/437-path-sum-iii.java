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
        HashMap<Integer,Integer> map = new HashMap<>();
        count=0;
        map.put(0,1);
        helper(root,map,0,targetSum);
        return count;
    }
    public void helper(TreeNode root,HashMap<Integer,Integer> map,int sum,int tsum){
        if(root==null) return;
        
        int mod = 1000000007;
        
        int vsum = ((sum%mod) + (root.val%mod))%mod;
        if(map.containsKey(vsum-tsum)){
            count += map.get(vsum-tsum);
        }
        map.put(vsum,map.getOrDefault(vsum,0)+1);
        helper(root.left,map,vsum,tsum);
        helper(root.right,map,vsum,tsum);
        map.put(vsum,map.get(vsum)-1);
    }
}