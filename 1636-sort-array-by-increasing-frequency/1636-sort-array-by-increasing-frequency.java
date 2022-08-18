class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        TreeSet<Integer>[] set = new TreeSet[nums.length+1];
        
        for(int i=0;i<=nums.length;i++){
            set[i] = new TreeSet<>();
        }
        
        for(int key : map.keySet()){
            int val = map.get(key);
            set[val].add(key);
        }
        
        int []res = new int[nums.length];
        int idx=0;
        
        for(int i=0;i<set.length;i++){
            for(Integer val : set[i].descendingSet()){
                for(int j=0;j<i;j++){
                    res[idx++] = val;
                }
            }
        }
        return res;
    }
}