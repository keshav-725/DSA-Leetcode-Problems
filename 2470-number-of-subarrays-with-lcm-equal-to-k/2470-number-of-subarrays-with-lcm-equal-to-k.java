class Solution {
    public long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
     
    // method to return LCM of two numbers
    public long lcm(long a, long b)
    {
        return (a / gcd(a, b)) * b;
    }
    public int subarrayLCM(int[] nums, int k) {
        
        int ans = 0;
        
        for(int i=0;i<nums.length;i++){
            long lcmval = 1;
            
            for(int j=i;j<nums.length;j++){
                
                lcmval = lcm(lcmval,nums[j]);

                if(lcmval==k){
                    ans++;
                }
            }
        }
        return ans;
    }
}