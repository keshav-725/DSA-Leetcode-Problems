class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st = new Stack<>();
        int []ans = new int[temp.length];
        for(int i=temp.length-1;i>=0;i--){
            int num = temp[i];
            
            while(st.size()>0 && num>=temp[st.peek()]){
                st.pop();
            }
            
            if(st.size()==0){
                ans[i] = 0;
            }else{
                ans[i] = st.peek()-i;
            }
            
            st.push(i);
        }
        return ans;
    }
}