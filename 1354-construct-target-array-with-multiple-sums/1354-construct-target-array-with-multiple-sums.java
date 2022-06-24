class Solution {
    public boolean isPossible(int[] target) {
        if (target.length <= 1) return target[0] == 1;
        
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int num : target) {
            sum += num;
            pq.offer(num);
        }
        
        while(sum > 1 && sum / 2 < pq.peek()) {
            int largest = pq.poll();
            sum -= largest;
            
            if (sum <= 1) return sum != 0;
            
            pq.offer(largest % (int)sum);
            sum += largest % sum;
        }
        return target.length == sum;
    }
}