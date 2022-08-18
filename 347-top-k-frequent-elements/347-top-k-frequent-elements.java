class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        ArrayList<Integer>[] list = new ArrayList[nums.length+1];
        
        for(int i=0;i<list.length;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int key : map.keySet()){
            int val = map.get(key);
            list[val].add(key);
        }
        
        int []ans = new int[k];
        int idx=0;
        for(int i=list.length-1;i>=0;i--){
            for(int j=0;j<list[i].size();j++){
                ans[idx]=list[i].get(j);
                idx++;
                if(idx==k) break;
            }
            if(idx==k) break;
        }
        return ans;
    }
}