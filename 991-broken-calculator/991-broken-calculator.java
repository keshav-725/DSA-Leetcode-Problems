class Solution {
    public int brokenCalc(int start, int target) {
        int ans = 0;
        while(start<target){
            if(target%2==0){
                target=target/2;
            }else{
                target=target+1;
            }
            ans++;
        }
        return ans+start-target;
    }
}