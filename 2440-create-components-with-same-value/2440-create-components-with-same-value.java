class Solution {
    public int componentValue(int[] nums, int[][] edges) {
        int sum = 0;
        
        for(int i=0;i<nums.length;i++){
            sum += nums[i];    
        }
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            graph.add(new ArrayList<>());
        }
        for(int []edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        for(int i=nums.length;i>0;i--){
            if(sum%i==0){
                if(dfs(graph,nums,sum/i,0,-1)==0) return i-1;
            }
        }
        return 0;
    }
    public int dfs(ArrayList<ArrayList<Integer>> graph,int []nums,int i,int idx,int parent){
        
        int tsum = nums[idx];
        for(int val : graph.get(idx)){
            if(val==parent) continue;
            tsum += dfs(graph,nums,i,val,idx);
        }
        if(tsum==i) return 0;
        return tsum;
    }
}