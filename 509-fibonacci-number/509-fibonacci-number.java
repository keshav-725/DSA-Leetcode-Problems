class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        int even = 0, odd = 1;

        for(int x = 1; x < n; x += 2){
            even += odd;
            odd += even;
        }
        if (n % 2 == 0) return even;
        else return odd;
    }
}