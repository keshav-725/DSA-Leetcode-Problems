class Solution {
    public int countHousePlacements(int n) {
        int m = 1000000007;
        long zero = 1;
        long one = 1;
        for(int i=1;i<n;i++){
            long tem = zero;
            zero = ((zero%m)+(one%m))%m;
            one = tem%m;
        }
        long res = ((zero%m)+(one%m))%m;
        long ans = ((res%m)*(res%m))%m;
        return (int)ans;
    }
}