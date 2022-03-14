// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code here
        int c0=0,c1=0,c2=0;
        int totalcount = 0;
        HashMap<String,Integer> map = new HashMap<>();
        map.put("0#0",1);
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='0') c0++;
            else if(ch=='1') c1++;
            else if(ch=='2') c2++;
            
            String diff = (c1-c0)+"#" + (c2-c1);
            if(map.containsKey(diff)){
                int count = map.get(diff);
                totalcount += count;
                map.put(diff,map.get(diff)+1);
            }else{
                map.put(diff,1);
            }
        }
        return totalcount;
    }
} 