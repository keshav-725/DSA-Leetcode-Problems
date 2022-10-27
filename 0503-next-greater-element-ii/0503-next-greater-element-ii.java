class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            st.push(i);
        }
        int []ans = new int[nums.length];
        for(int i=n-1;i>=0;i--){
            ans[i] = -1;
            
            while(st.size()>0 && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            
            if(!(st.isEmpty())){
                ans[i] = nums[st.peek()];
            }
            st.push(i);
        }
        return ans;
    }
}