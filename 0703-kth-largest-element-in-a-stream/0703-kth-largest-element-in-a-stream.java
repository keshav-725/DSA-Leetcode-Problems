class KthLargest {

    PriorityQueue<Integer> pq;
    int check;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        check = k;
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=0 && k>0;i--,k--){
            pq.add(nums[i]);
        }
        // System.out.println(pq);
    }
    
    public int add(int val) {
        if(pq.size()<check){
            pq.add(val);
        }
        else if(pq.size()>0 && pq.peek()<val){
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */