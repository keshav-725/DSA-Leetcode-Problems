class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                open.push(i);
            }else if(ch==')'){
                if(open.size()>0){
                    open.pop();
                }
                else{
                    if(star.size()>0){
                        star.pop();
                    }else{
                        return false;
                    }
                }
            }else if(ch=='*'){
                star.push(i);
            }
        }
        if(open.size()>star.size()){
            return false;
        }
        while(open.size()>0){
            if(open.peek()<star.peek()){
                open.pop();
                star.pop();
            }else{
                return false;
            }
        }
        return true;
    }
}