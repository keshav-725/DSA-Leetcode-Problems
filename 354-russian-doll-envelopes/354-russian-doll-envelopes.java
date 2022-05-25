class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        return findLongestIncreasingSubsequence(envelopes);
    }
    
    public int findLongestIncreasingSubsequence(int[][] envelopes){
        List<Integer> subseq = new ArrayList<>();
        subseq.add(envelopes[0][1]);
        for(int i = 1 ; i < envelopes.length ; i++){
            if(envelopes[i][1] > subseq.get(subseq.size() - 1)) 
                subseq.add(envelopes[i][1]);
            else {
                subseq.set(binarySearch(envelopes, envelopes[i][1], subseq) , envelopes[i][1]);
            }
        }
        return subseq.size();
    }
    
    public int binarySearch(int[][] envelopes, int target, List<Integer> subseq){
        int low = 0 , high = subseq.size() - 1 , mid = 0 , ans = 0;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(subseq.get(mid) >= target){
                ans = mid;
                high = mid - 1;
            }
            else 
                low = mid + 1;
        }
        return ans;
    }
}