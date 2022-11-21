class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] shoot = new int[100_000];

        for (int n : nums){
            if(n > 0 && n < 100_000)
                shoot[Math.abs(n)]++;
        }
        for (int n = 1; n < 100_000; n++){
            if (shoot[n] == 0){
                return n;
            }
        }
        return 100_001;
    }
}