class Solution {
    public int[] singleNumber(int[] nums) {
        int res=0;
        for(int num:nums){
            res = res ^ num;
        }
        int rsbm = (res & -res);
        int seta = 0;
        int setb = 0;
        for(int num:nums){
            if((num&rsbm)==0) seta = seta^num;
            else setb = setb^num;
        }
        int []ans = new int[2];
        ans[0] = seta;
        ans[1] = setb;
        
        return ans;
    }
}