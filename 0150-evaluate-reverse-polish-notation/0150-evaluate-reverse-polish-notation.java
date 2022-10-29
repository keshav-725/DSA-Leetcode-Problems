class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stint = new Stack<>();
        Stack<String> stchar = new Stack<>();
        
        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int fnum = stint.pop();
                int snum = stint.pop();
                int val;
                if(s.equals("+")){
                    val = fnum + snum;
                }else if(s.equals("-")){
                    val = snum - fnum;
                }else if(s.equals("*")){
                    val = fnum * snum;
                }else {
                    val = snum/fnum;
                }
                stint.push(val);
            }else{
                stint.push(Integer.parseInt(s));
            }
        }
        return stint.pop();
    }
}