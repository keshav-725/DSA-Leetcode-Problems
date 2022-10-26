class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
			return new int[0];
		}

        int n = nums.length;
        int []ans = new int[n-k+1];
        int ri=0;
        LinkedList<Integer> queue = new LinkedList<>();
        
        for(int i=0;i<nums.length;i++){
            
            while(queue.size()>0 && queue.getFirst()<(i-k+1)){
                queue.removeFirst();
            }
            
            while(queue.size()>0 && nums[queue.getLast()]<nums[i]){
                queue.removeLast();
            }
            
            queue.addLast(i);
            
            if(i>=k-1){
                ans[ri++] = nums[queue.getFirst()];
            }
        }
        return ans;
    }
}