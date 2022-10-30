class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int []left = new int[n];
        int []right = new int[n];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<heights.length;i++){
            int num = heights[i];
            
            while(st.size()>0 && heights[st.peek()]>num){
                st.pop();
            }
            if(st.size()==0){
                left[i] = -1;
            }else{
                left[i] = st.peek();
            }
            st.push(i);
        }
        
        st = new Stack<>();
        
        for(int i=heights.length-1;i>=0;i--){
            int num = heights[i];
            
            while(st.size()>0 && heights[st.peek()]>=num){
                st.pop();
            }
            if(st.size()==0){
                right[i] = heights.length;
            }else{
                right[i] = st.peek();
            }
            st.push(i);
        }
        int max = 0;
        for(int i=0;i<heights.length;i++){
            max = Math.max((right[i]-left[i]-1)*heights[i],max);
            // System.out.println("left-> "+left[i]+" right-> "+right[i]);
        }
        return max;
    }
}