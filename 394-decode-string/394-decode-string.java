class Solution {
    public String decodeString(String s) {
        Stack<Integer> intstack = new Stack<>();
        Stack<String> charstack = new Stack<>();
        int num =0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='0' && ch<='9'){
                int tnum = ch-'0';
                num = num*10 + tnum;
            }else if(ch=='['){
                intstack.push(num);
                num = 0;
                charstack.push(ch+"");
            }else if(ch==']'){
                String ans = "";
                int val = intstack.pop();
                // System.out.println(val);
                StringBuilder sb = new StringBuilder("");
                while(!(charstack.peek().equals("["))){
                    sb.insert(0,charstack.pop());
                }
                charstack.pop();
                for(int j=0;j<val;j++){
                    ans += sb.toString();
                }
                // System.out.println(ans);
                charstack.push(ans);
            }else{
                charstack.push(ch+"");
            }
        }
        String result = "";
        while(charstack.size()>0){
            result = charstack.pop()+result;
        }
        return result;
    }
}