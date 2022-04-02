// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str).length());
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public String findSubString( String str) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }
        }
        int count = map.size();
        int i=0,j=0,testcount=0;
        int minlen = Integer.MAX_VALUE;
        map = new HashMap<>();
        String ans="";
        while(i<str.length()){
            char ch = str.charAt(i);
            if(map.size()<count){
                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch)+1);
                }else{
                    map.put(ch,1);
                }
                i++;
            }
            while(map.size()==count){
                if(minlen>(i-j)){
                    minlen = i-j;
                    ans = str.substring(j,i);
                }
                char jch = str.charAt(j);
                if(map.getOrDefault(jch,0)<=1){
                    map.remove(jch);
                }else{
                    map.put(jch,map.getOrDefault(jch,0)-1);
                }
                j++;
            }
        }
        return ans;
    }
}