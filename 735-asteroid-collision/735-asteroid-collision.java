class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            int num = asteroids[i];
            
            if(num>0){
                st.push(num);
            }else{
                while(st.size()>0 && st.peek()>0 && Math.abs(num)>st.peek()){
                    st.pop();
                }
                if(st.size()>0 && Math.abs(num)==st.peek()){
                    st.pop();
                    continue;
                }
                if(st.size()==0) st.push(num);
                else{
                    if(st.peek()<0) st.push(num);
                }
                // System.out.println(st);
            }
        }
        int []ans = new int[st.size()];
        int i=ans.length-1;
        while(st.size()>0){
            int val = st.pop();
            ans[i] = val;
            i--;
        }
        return ans;
    }
}