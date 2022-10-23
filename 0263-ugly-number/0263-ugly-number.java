class Solution {
    public boolean isUgly(int n) {
        int []arr = {2,3,5};
        int i=2;
        while(i>=0 && n>1){
            while(n>1 && n%arr[i]==0){
                n = n/arr[i];
            }
            i--;
        }
        return n==1;
    }
}