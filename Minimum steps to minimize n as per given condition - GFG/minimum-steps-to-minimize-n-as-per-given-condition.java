//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minSteps(n));
                    
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minSteps(int N) 
	{ 
	    // Your code goes here
	    int []dp = new int[N+1];
	    for(int i=2;i<=N;i++){
	        int res = dp[i-1];
	        if(i%2==0){
	            res = Math.min(res,dp[i/2]);
	        }
	        if(i%3==0){
	            res = Math.min(res,dp[i/3]);
	        }
	        dp[i]=res+1;
	    }
	    return dp[N];
	} 
}
