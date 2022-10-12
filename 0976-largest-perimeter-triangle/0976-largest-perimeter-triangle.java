class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        int a,b,c;
        c = n-1;
        b = n-2;
        a = n-3;
        Arrays.sort(nums);
        while(a>=0){
            if((nums[a] + nums[b] > nums[c]) && (nums[a] + nums[c] > nums[b]) && (nums[b] + nums[c] > nums[a])){
                return (nums[a] + nums[b] + nums[c]);
            }
            else{
                a--;
                b--;
                c--;
            }
        }
        return 0;
    }
}