// { Driver Code Starts
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
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    int max = Integer.MIN_VALUE;
	    int []dp = new int[arr.length];
	    for(int i=0;i<arr.length;i++){
	        int val=arr[i],j=i-1;
	        while(j>=0){
	            if(arr[j]<arr[i]){
	                int sum = dp[j]+arr[i];
	                val = Math.max(val,sum);
	            }
	            j--;
	        }
	        dp[i]=val;
	        max = Math.max(dp[i],max);
	    }
	    return max;
	}  
}