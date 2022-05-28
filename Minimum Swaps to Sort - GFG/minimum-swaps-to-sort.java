// { Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        HashMap<Integer,Integer>map=new HashMap<>();
       int temp[]=new int[nums.length];
       int count=0;
       for(int i=0;i<nums.length;i++){
           temp[i]=nums[i];
       }
       Arrays.sort(temp);
       for(int i=0;i<nums.length;i++){
           map.put(nums[i],i);
       }
       for(int i=0;i<nums.length;i++){
           int check=nums[i];
           if(nums[i]!=temp[i]){
               count++;
               
               // swaping element in array
               swap(nums,i,map.get(temp[i]));
               
               //updating map elements
               map.put(check,map.get(temp[i]));
               map.put(temp[i],i);
           }
       }
       return count;
    }
    static void swap(int arr[],int i, int j){
       int temp=arr[i];
       arr[i]=arr[j];
       arr[j]=temp;
   }
}