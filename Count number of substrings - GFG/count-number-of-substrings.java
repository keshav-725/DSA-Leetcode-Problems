// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    long substrCount (String S, int K) {
        // your code here
        long ans = atMostKDistinctCharacter(S,K)-atMostKDistinctCharacter(S,K-1);
        return ans;
    }
    long atMostKDistinctCharacter(String s,int k){
        int []arr = new int[26];
        int count = 0,j=0;
        long totalcount = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(arr[ch-'a']==0) count++;
            arr[ch-'a']++;
            while(count>k){
                char jch = s.charAt(j);
                if(arr[jch-'a']==1) count--;
                arr[jch-'a']--;
                j++;
            }
            if(count<=k){
                totalcount += i-j+1;
            }
        }
        return totalcount;
    }
}