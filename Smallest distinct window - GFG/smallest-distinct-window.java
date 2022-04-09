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
        // Your code goes here
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<str.length();i++){
            set.add(str.charAt(i));
        }
        int count = set.size();
        HashMap<Character,Integer> map = new HashMap<>();
        int j = 0;
        int minlen = Integer.MAX_VALUE;
        String ans = "";
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(count==map.size()){
                if(minlen>i-j+1){
                    ans = str.substring(j,i+1);
                    minlen = i-j+1;
                }
                char jch = str.charAt(j);
                if(map.get(jch)==1){
                    map.remove(jch);
                }else{
                    map.put(jch,map.get(jch)-1);
                }
                j++;
            }
        }
        return ans;
    }
}