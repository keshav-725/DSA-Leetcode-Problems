class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<num.length();i++){
            int val = (num.charAt(i)-'0');
            while(st.size()>0 && st.peek()>val && k>0){
                st.pop();
                k--;
            }
            st.push(val);
        }
        while(st.size()>0 && k>0){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder("");
        while(st.size()>0){
            sb.append(st.pop()+"");
        }
        sb.reverse();
        int t=0;
        while(t<sb.length() && sb.charAt(t)=='0') t++;
        sb.delete(0,t);
        if(sb.length()==0) sb.append("0");
        String res = sb.toString();
        return res;
    }
}