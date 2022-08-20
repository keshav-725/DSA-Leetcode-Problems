class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        return getsubset(nums,0);
    }
    public List<List<Integer>> getsubset(int[] nums,int i){
        if(i==nums.length){
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }
        int num = nums[i];
        List<List<Integer>> temp = getsubset(nums,i+1);
        List<List<Integer>> res = new ArrayList<>();
        for(i=0;i<temp.size();i++){
            res.add(temp.get(i));
            ArrayList<Integer> t1 = new ArrayList<>(temp.get(i));
            t1.add(num);
            res.add(t1);
        }
        return res;
    }
}