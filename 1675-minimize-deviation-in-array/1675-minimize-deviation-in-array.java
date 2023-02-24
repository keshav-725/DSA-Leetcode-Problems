class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int num : nums){
            if(num%2!=0){
                set.add(num*2);
            }else{
                set.add(num);
            }
        }
        int ans = Integer.MAX_VALUE;
        while(true){
            int maxVal = set.last();
            int minVal = set.first();
            
            int diff = maxVal-minVal;
            ans = Math.min(diff,ans);
            
            if(maxVal%2==0){
                set.remove(maxVal);
                set.add(maxVal/2);
            }else{
                return ans;
            }
        }
    }
}