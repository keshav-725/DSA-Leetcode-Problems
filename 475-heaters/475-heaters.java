class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int min = Integer.MIN_VALUE;
        Arrays.sort(heaters);
        for(int i=0;i<houses.length;i++){
            int val= findNearest(heaters,houses[i]);
            // System.out.println(val);
            min = Math.max(min,val);
        }
        return min;
    }
    public int findNearest(int []heaters,int num){
        // System.out.println("num"+num);
        int left =0,right=heaters.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(heaters[mid]==num) return 0;
            else if(heaters[mid]>num){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        int lval = Integer.MAX_VALUE,rval = Integer.MAX_VALUE;
        if(right>=0) lval = Math.abs(num-heaters[right]);
        if(left<heaters.length) rval = Math.abs(num-heaters[left]);
        return Math.min(lval,rval);
    }
}