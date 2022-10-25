class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(num==0){
                list.add(i);
                continue;
            }
            prod *= num;
        }
        int []ans = new int[nums.length];
        if(list.size()>1) return ans;
        int i=0;
        for(int num : nums){
            if(list.size()==1){
                if(list.get(0)==i){
                    ans[i] = prod;
                }
            }else{
                ans[i] = prod/num;
            }
            i++;
        }
        return ans;
    }
}