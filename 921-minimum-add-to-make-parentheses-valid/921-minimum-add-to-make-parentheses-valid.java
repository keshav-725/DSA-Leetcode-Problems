class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0,open=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch=='('){
                open++;
            }else{
                if(open==0) count++;
                else open--;
            }
        }
        return count+open;
        
    }
}