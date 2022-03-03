class Solution {
    public int evaluate(int a,char op,int b) {
        if(op=='+'){
            return a+b;
        }else if(op=='-'){
            return a-b;
        }else if(op=='*'){
            return a*b;
        }else if(op=='/'){
            return a/b;
        }
        return 0;
    }
    public int precedence(char op) {
        if(op=='+' || op=='-'){
            return 1;
        }else if(op=='*' || op=='/'){
            return 2;
        }
        return 0;
    }
    public String refine(String s){
        StringBuilder str = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch==' ') continue;
            if(ch=='+'){
                if(str.length()==0 || str.charAt(str.length()-1)=='('){
                    str.append("0+");
                }
                else if(str.charAt(str.length()-1)=='+' || str.charAt(str.length()-1)=='-'){
                    continue;
                }else{
                    str.append('+');
                }
            }else if(ch=='-'){
                if(str.length()==0 || str.charAt(str.length()-1)=='('){
                    str.append("0-");
                }
                else if(str.charAt(str.length()-1)=='+'){
                    str.setCharAt(str.length()-1,'-');
                }else if(str.charAt(str.length()-1)=='-'){
                    str.setCharAt(str.length()-1,'+');   
                }else{
                    str.append("-");
                }
            }else{
                str.append(ch);
            }
        }
        return str.toString();
    }
    public int calculate(String s) {
        s=refine(s);
        Stack<Character> operator = new Stack<>();
        Stack<Integer> operand = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='0' && ch<='9'){
                int num = 0;
                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                    num = num*10 + (s.charAt(i)-'0');
                    i++;
                }
                operand.push(num);
                i--;
            }else if(ch=='('){
                operator.push(ch);
            }else if(ch==')'){
                while(operator.peek()!='('){
                    int b = operand.pop();
                    int a = operand.pop();
                    char op = operator.pop();
                    operand.push(evaluate(a,op,b));
                }
                operator.pop();
            }else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                while(operator.size()>0 && operator.peek()!='(' && precedence(operator.peek())>=precedence(ch)){
                    int b = operand.pop();
                    int a = operand.pop();
                    char op = operator.pop();
                    operand.push(evaluate(a,op,b));
                }
                operator.push(ch);
            }
        }
         while(operator.size()>0){
            int b = operand.pop();
            int a = operand.pop();
            char op = operator.pop();
            operand.push(evaluate(a,op,b));
         }
         return operand.peek();
    }
}