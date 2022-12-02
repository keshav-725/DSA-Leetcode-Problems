class Solution {
    public int bestClosingTime(String cust) {
        int totalY = 0;
        
        for(char ch : cust.toCharArray()){
            ch += (ch=='Y') ? 1 : 0;
        }
        int currY=0,currN=0,ans = Integer.MAX_VALUE,res=0;
        for(int i=0;i<cust.length();i++){
            char ch = cust.charAt(i);
            int penalty = totalY - currY + currN;
            
            if(ans>penalty){
                ans = penalty;
                res = i;
            }
            
            currY += (ch=='Y') ? 1 : 0;
            currN += (ch=='N') ? 1 : 0;
            
        }
        int penalty = totalY - currY + currN;
            
        if(ans>penalty){
            ans = penalty;
            res = cust.length();
        }
        return res;
    }
}