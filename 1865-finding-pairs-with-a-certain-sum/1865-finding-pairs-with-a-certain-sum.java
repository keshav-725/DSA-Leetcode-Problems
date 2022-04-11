class FindSumPairs {
    HashMap<Integer,Integer> map1 = new HashMap<>();
    HashMap<Integer,Integer> map2 = new HashMap<>();
    int []num1;
    int []num2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        num1 = new int[nums1.length];
        num2 = new int[nums2.length];
        for(int i=0;i<nums1.length;i++){
            num1[i] = nums1[i];
            map1.put(nums1[i],map1.getOrDefault(nums1[i],0)+1);
        }
        for(int i=0;i<nums2.length;i++){
            num2[i]=nums2[i];
            map2.put(nums2[i],map2.getOrDefault(nums2[i],0)+1);
        }
        
    }
    
    public void add(int index, int val) {
        int num = num2[index];
        int newnum = num+val;
        num2[index] = newnum;
        if(map2.get(num)==1){
            map2.remove(num);
        }else{
            map2.put(num,map2.getOrDefault(num,0)-1);
        }
        map2.put(newnum,map2.getOrDefault(newnum,0)+1);
    }
    
    public int count(int tot) {
        int count = 0;
        for(int key:map1.keySet()){
            if(map2.containsKey(tot-key)){
                int m1 = map1.get(key);
                int m2 = map2.get(tot-key);
                count += m1*m2;
            }
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */