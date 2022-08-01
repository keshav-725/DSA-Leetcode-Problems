class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(name.charAt(0)!=typed.charAt(0)) return false;
        
        int nidx=1,tidx=1;
        
        while(nidx<name.length() && tidx<typed.length()){
            char nch = name.charAt(nidx);
            char tch = typed.charAt(tidx);
            
            if(nch==tch){
                nidx++;
                tidx++;
            }else{
                if(name.charAt(nidx-1)==tch){
                    tidx++;
                }else{
                    return false;
                }
            }
        }
        if(nidx!=name.length()) return false;
        while(tidx<typed.length()){
            if(typed.charAt(tidx)==name.charAt(nidx-1)) tidx++;
            else return false;
        }
        return true;
    }
}