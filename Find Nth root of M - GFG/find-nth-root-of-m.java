//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int NthRoot(int n, int m)
    {
        // code here
        int left = 1,right=m;
        int pans=0;
        while(left<=right){
            int mid = left + (right-left)/2;
            
            int k = n;
            long val=1;
            while(k-->0){
                val = val * mid;
                if(val>m) break;
            }
            if(val>m){
                right=mid-1;
            }else{
                pans=mid;
                left=mid+1;
            }
        }
        int nval=1;
        while(n-->0){
            nval = nval*pans;
        }
        if(nval==m) return pans;
        return -1;
    }
}