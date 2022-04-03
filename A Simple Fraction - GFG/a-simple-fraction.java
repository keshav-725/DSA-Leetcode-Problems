// { Driver Code Starts
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
            String[] S = br.readLine().trim().split(" ");
            int numerator = Integer.parseInt(S[0]);
            int denominator = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            String ans = ob.fractionToDecimal(numerator, denominator);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String  fractionToDecimal(int numerator, int denominator)
    {
        // code here
        StringBuilder sb = new StringBuilder("");
        int wholenum = numerator/denominator;
        HashMap<Integer,Integer> map = new HashMap<>();
        sb.append(wholenum + "");
        int rem = numerator % denominator;
        if(rem==0){
            return sb.toString();
        }
        sb.append(".");
        while(rem!=0){
            if(!map.containsKey(rem)){
                map.put(rem,sb.length());
                rem = rem*10;
                int quo = rem/denominator;
                rem = rem % denominator;
                sb.append(quo+"");
            }else{
                int position = map.get(rem);
                sb.insert(position,'(');
                sb.append(")");
                return sb.toString();
            }
        }
        return sb.toString();
    }
}