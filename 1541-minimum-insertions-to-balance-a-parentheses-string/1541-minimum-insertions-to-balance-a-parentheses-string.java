class Solution {
    public int minInsertions(String s) {
        int open = 0,additional = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                open++;
            }else if(ch==')'){
                if(i+1<s.length() && s.charAt(i+1)==')'){
                    if(open==0){
                        additional++;
                    }else{
                        open--;   
                    }
                    i++;
                }else{
                    if(open==0){
                        additional += 2;
                    }
                    else{
                        additional++;
                        open--;   
                    }
                }
            }
        }
        additional += open*2;
        return additional;
    }
}