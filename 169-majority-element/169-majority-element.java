class Solution {
    public int majorityElement(int[] nums) {
        int count = 1,max = nums[0];
        for(int i=1;i<nums.length;i++){
            //System.out.println(count);
            if(max == nums[i]){
                count++;
            }else{
                if(count>0){
                    count--;
                }else{
                    count=1;
                    max = nums[i];
                }
            }
        }
        return max;
    }
}