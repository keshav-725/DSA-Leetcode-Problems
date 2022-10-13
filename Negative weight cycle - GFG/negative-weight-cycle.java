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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        int []res = new int[n];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[0]=0;
        int []resp;
        for(int i=1;i<=n-1;i++){
            resp = res.clone();
            for(int []arr : edges){
                int u = arr[0];
                int v = arr[1];
                int uv = arr[2];
                
                if(res[u]==Integer.MAX_VALUE) continue;
                else{
                    resp[v] = Math.min(resp[v],res[u]+uv);
                }
            }
            res = resp;
        }
        resp = res.clone();
        for(int []arr : edges){
            int u = arr[0];
            int v = arr[1];
            int uv = arr[2];
            
            if(res[u]==Integer.MAX_VALUE) continue;
            else{
                if(resp[v]>res[u]+uv) return 1;
            }
        }
        return 0;
    }
}