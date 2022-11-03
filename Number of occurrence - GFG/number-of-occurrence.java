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
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    public int left(int []arr,int x){
        int left = 0,right=arr.length-1;
        int pans=-1;
        while(left<=right){
            int mid = left + (right-left/2);
            if(arr[mid]>=x){
                pans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return pans;
    }
    public int right(int []arr,int x){
        int left = 0,right=arr.length-1;
        int pans=-1;
        while(left<=right){
            int mid = left + (right-left/2);
            if(arr[mid]<=x){
                pans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return pans;
    }
    int count(int[] arr, int n, int x) {
        // code here
        int l = left(arr,x);
        int r = right(arr,x);
        if(l==-1) return 0;
        return (r-l+1);
    }
}