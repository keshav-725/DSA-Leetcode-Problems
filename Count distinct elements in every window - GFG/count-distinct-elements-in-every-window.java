// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int arr[], int n, int k)
    {
        // code here 
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<k;i++){
            int num = arr[i];
            map.put(num,map.getOrDefault(num,0)+1);
        }
        list.add(map.size());
        int i = k;
        int j=0;
        for(;i<n;i++){
            int num = arr[i];
            map.put(num,map.getOrDefault(num,0)+1);
            int numj = arr[j];
            if(map.get(numj)==1){
                map.remove(numj);
            }else{
                map.put(numj,map.get(numj)-1);
            }
            j++;
            list.add(map.size());
        }
        return list;
    }
}

