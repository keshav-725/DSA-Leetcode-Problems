class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int []ans = new int[spells.length];
        for(int i=0;i<spells.length;i++){
            int spell = spells[i];
            int val = check(spell,potions,success);
            int res = potions.length-val;
            // System.out.println(res);
            ans[i] = res;
        }
        return ans;
    }
    public int check(int num,int []potion,long success){
        int left = 0,right = potion.length-1;
        int ans = potion.length;
        double cval = (1.0 * success)/num;
        while(left<=right){
            int mid = left + (right-left)/2;

            if((potion[mid]*1.0)>=cval){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
}