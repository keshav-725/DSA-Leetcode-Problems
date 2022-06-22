import java.math.BigInteger;
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<BigInteger> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            pq.add(new BigInteger(nums[i]));
        }
        for(int i=1;i<k;i++){
            pq.remove();
        }
        return String.valueOf(pq.peek());
    }
}