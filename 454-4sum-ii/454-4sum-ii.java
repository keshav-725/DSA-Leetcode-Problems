class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        int n = nums1.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum = nums1[i]+nums2[j];
                map1.put(sum,map1.getOrDefault(sum,0)+1);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum = nums3[i]+nums4[j];
                map2.put(sum,map2.getOrDefault(sum,0)+1);
            }
        }
        int count = 0;
        for(int key : map1.keySet()){
            int rem = 0-key;
            if(map2.containsKey(rem)){
                int m1 = map1.get(key);
                int m2 = map2.get(rem);
                count += m1*m2;
            }
        }
        return count;
    }
}