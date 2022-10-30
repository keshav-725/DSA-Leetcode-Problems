class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        
        Stack<Integer> st = new Stack<>();
        int max = 0;
        
        for(int i=0;i<=heights.length;i++){
            
            while(st.size()>0 && (i==n || heights[st.peek()]>=heights[i])){
                int temp = heights[st.pop()];
                int width;
                if(st.size()==0){
                    width = i;
                }else{
                    width = i-st.peek()-1;
                }
                
                max = Math.max(width*temp,max);
            }
            st.push(i);
        }
        return max;
    }
}