// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


class Solution{
    
  
    ArrayList<Integer> smallestSubsegment(int a[], int n)
    {
        // Complete the function
        int left=0,right=0,pleft=0,pright=0;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int maxlen = Integer.MIN_VALUE;
        int minlen = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int num = a[i];
            if(map.containsKey(num)){
                map.get(num).add(i);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(num,list);
            }
            if(maxlen<map.get(num).size()){
                ArrayList<Integer> temp = map.get(num);
                maxlen = temp.size();
                left = temp.get(0);
                right = temp.get(temp.size()-1);
            }
            if(maxlen==map.get(num).size()){
                ArrayList<Integer> temp = map.get(num);
                int cleft = temp.get(0);
                int cright = temp.get(temp.size()-1);
                if((right-left+1)>(cright-cleft+1)){
                    left = cleft;
                    right = cright;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=left;i<=right;i++){
            ans.add(a[i]);
        }
        return ans;
    }
  
    
}


// { Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    res = obj.smallestSubsegment(arr, sizeOfArray);
		    for(int i:res)
		        System.out.print(i + " ");
		    System.out.println();
		}
	}
}


            

  // } Driver Code Ends