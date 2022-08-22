class Solution {
    public boolean isPowerOfFour(int n) {
        if(!isPowerOfTwo(n)) return false;
        int count = 0;
        while(n!=1){
            n=n>>>1;
            count++;
        }
        
        return (count&1)==0;
        
    }
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n & (n-1))==0;
    }
}