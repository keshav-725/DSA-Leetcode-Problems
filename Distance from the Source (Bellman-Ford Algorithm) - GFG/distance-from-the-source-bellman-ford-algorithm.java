//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<>();
                t1.add(u);
                t1.add(v);
                t1.add(w);
                edges.add(t1);
            }

            int S = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            int[] ptr = ob.bellman_ford(V, edges, S);

            for (i = 0; i < ptr.length; i++) System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution {
    static int[] bellman_ford(int n, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int []res = new int[n];
        Arrays.fill(res,100000000);
        res[S]=0;
        int []resp;
        for(int i=1;i<=n-1;i++){
            resp = res.clone();
            for(ArrayList<Integer> list : edges){
                int u = list.get(0);
                int v = list.get(1);
                int uv = list.get(2);
                
                if(res[u]==100000000) continue;
                else{
                    resp[v] = Math.min(resp[v],res[u]+uv);
                }
            }
            res = resp;
        }
        resp = res.clone();
        for(ArrayList<Integer> list : edges){
            int u = list.get(0);
            int v = list.get(1);
            int uv = list.get(2);
            
            if(res[u]==100000000) continue;
            else{
                if(resp[v]>res[u]+uv) return new int[]{-1};
            }
        }
        return res;
    }
}
