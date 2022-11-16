class Solution {
    public int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    public int subarrayGCD(int[] nums, int k) {
        int ans = 0;
        
        for(int i=0;i<nums.length;i++){
            int gcdval = nums[i];
            
            for(int j=i;j<nums.length;j++){
                gcdval = gcd(gcdval,nums[j]);
                
                if(gcdval==k){
                    ans++;
                }
            }
        }
        return ans;
    }
}