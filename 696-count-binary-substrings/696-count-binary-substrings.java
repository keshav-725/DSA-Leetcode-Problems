class Solution {
    public int countBinarySubstrings(String s) {
        int prev = 0,curr=1,i=1,count =0;
        while(i<s.length()){
            if(s.charAt(i)!=s.charAt(i-1)){
                count += Math.min(curr,prev);
                prev = curr;
                curr = 1;
            }else{
                curr++;
            }
            i++;
        }
        count += Math.min(prev,curr);
        return count;
    }
}