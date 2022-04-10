// { Driver Code Starts

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[] arr = new int[m];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Tasks ans = new Solution().findTasks(arr, m, n);
            for (Integer x : ans.tanya) {
                System.out.print(x + " ");
            }
            System.out.println();
            for (Integer x : ans.manya) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

class Tasks {
    ArrayList<Integer> tanya, manya;

    Tasks() {
        tanya = new ArrayList<>();
        manya = new ArrayList<>();
    }
}

// } Driver Code Ends


// check Tasks class in driver

class Solution {
    Tasks findTasks(int[] arr, int m, int n) {
        // code here
        Tasks task = new Tasks();
        int prev = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],1);
        }
        for(int i=1;i<=n;i++){
            if(!map.containsKey(i)){
                if(prev==0){
                    task.tanya.add(i);
                    prev=1;
                }else{
                    task.manya.add(i);
                    prev=0;
                }
            }
        }
        return task;
    }
}
