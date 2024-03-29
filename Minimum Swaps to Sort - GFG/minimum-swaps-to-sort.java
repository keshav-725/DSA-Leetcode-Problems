//{ Driver Code Starts
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
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        int n = nums.length;
        int []temp = Arrays.copyOfRange(nums,0,n);
        
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(temp);
        
        for(int i=0;i<temp.length;i++){
            map.put(nums[i],i);
        }
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != temp[i]){
                ans++;
                int init = nums[i];
                
                swap(nums,i,map.get(temp[i]));
                
                map.put(init,map.get(temp[i]));
                map.put(temp[i],i);
            }
        }
        return ans;
    }
    public void swap(int []nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}