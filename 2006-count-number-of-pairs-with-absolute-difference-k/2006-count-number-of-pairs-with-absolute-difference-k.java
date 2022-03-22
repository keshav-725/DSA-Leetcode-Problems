class Solution {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i , map.getOrDefault(i , 0)+1);
        }
        int totalcount =0;
        for(int i : nums){
            int comp = i+k;
            if(map.containsKey(comp)){
                int count = map.get(comp);
                totalcount += count;
            }
        }
         return totalcount;
    }
}