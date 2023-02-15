class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int rem=0,sum=0,i=num.length-1;
        List<Integer> ans = new ArrayList<>();
        while(i>=0 || k>0 || rem>0){
            if(i<0){
                sum = k%10 + rem;
            }else{
                sum = num[i] + k%10 + rem;
            }
            k = k/10;
            rem = sum/10;
            ans.add(sum%10);
            i--;
        }
        Collections.reverse(ans);
        return ans;
    }
}