// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxlen=0;
        int i=0,j=0;
        while(i<s.length()){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()>k){
                if(map.getOrDefault(s.charAt(j),0)<=1){
                    map.remove(s.charAt(j));
                }else{
                    map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)-1);
                }
                j++;
            }
            if(map.size()==k){
                maxlen = Math.max(maxlen,i-j+1);
            }
            i++;
        }
        return maxlen==0?-1:maxlen;
    }
}