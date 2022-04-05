// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] X = new int[N];
            int[] Y = new int[N];
            
            for(int i=0; i<N; i++)
            {
                X[i] = Integer.parseInt(S1[i]);
                Y[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.numOfPairs(X,Y,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numOfPairs(int[] X, int[] Y, int N) {
        // code here
        HashMap<Integer,Integer> xmap = new HashMap<>();
        HashMap<Integer,Integer> ymap = new HashMap<>();
        HashMap<String,Integer> xymap = new HashMap<>();
        
        int count = 0;
        
        for(int i=0;i<N;i++){
            int xcount = xmap.getOrDefault(X[i],0);
            xmap.put(X[i],xcount+1);
            int ycount = ymap.getOrDefault(Y[i],0);
            ymap.put(Y[i],ycount+1);
            String str = X[i]+"*"+Y[i];
            int xycount = xymap.getOrDefault(str,0);
            xymap.put(str,xycount+1);
            count += xcount + ycount - 2*xycount;
            
        }
        return count;
    }
};