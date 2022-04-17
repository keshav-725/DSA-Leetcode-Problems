class Solution {
    public int singleNumber(int[] nums) {
        int tn = -1;
        int tn1 = 0;
        int tn2 = 0;
        
        for(int num : nums){
            int cwtn = num & tn;
            int cwtn1 = num & tn1;
            int cwtn2 = num & tn2;
            
            tn = tn & ~cwtn;
            tn1 = tn1 | cwtn;
            
            tn1 = tn1 & ~cwtn1;
            tn2 = tn2 | cwtn1;
            
            tn2 = tn2 & ~cwtn2;
            tn = tn | cwtn2;
        }
        return tn1;
    }
}