//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        int [][]dp = new int[2][n];
        dp[0][0] = arr[0];
        dp[1][0] = 0;
        
        for(int i=1;i<n;i++){
            dp[0][i] = dp[1][i-1]+arr[i];
            dp[1][i] = Math.max(dp[0][i-1],dp[1][i-1]);
        }
        return Math.max(dp[0][n-1],dp[1][n-1]);
    }
}