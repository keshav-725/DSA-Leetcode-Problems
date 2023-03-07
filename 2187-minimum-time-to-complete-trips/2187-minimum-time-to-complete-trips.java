class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int min = time[0];

        for(int i: time) 
            min = Math.min(min, i);

        long r = totalTrips * (long)min, l = 1l, ans = r;

        while(l <= r) {
            long mid = l + (r - l)/2;
            if(check(mid, time, totalTrips)) {
                ans = mid;
                r = mid - 1;
            }else l = mid + 1;
        }

        return ans;
    }
    
    boolean check(long t, int[] time, int totalTrips){
        long total = 0;
        for(int i: time) {
            total += t/i;
        }
        return total >= totalTrips;
    }
}