// { Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Solution obj = new Solution();
                ArrayList <Integer> res = obj.verticalOrder(root);
                for (Integer num : res) System.out.print(num + " "); 
                System.out.println();
    	        
	        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static class Pair{
        Node root;
        int level;
        Pair(Node root,int level){
            this.root = root;
            this.level = level;
        }
    }
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        LinkedList<Pair> queue = new LinkedList<>();
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        queue.add(new Pair(root,0));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(queue.size()>0){
            int size = queue.size();
            while(size-->0){
                Pair rm = queue.removeFirst();
                if(!map.containsKey(rm.level)){
                    map.put(rm.level,new ArrayList<>());
                }
                map.get(rm.level).add(rm.root.data);
                min = Math.min(min,rm.level);
                max = Math.max(max,rm.level);
                if(rm.root.left!=null) queue.addLast(new Pair(rm.root.left,rm.level-1));
                if(rm.root.right!=null) queue.addLast(new Pair(rm.root.right,rm.level+1));
                
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int diff = 0-min;
        for(int i=min;i<=max;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp = map.get(i);
            for(int j=0;j<temp.size();j++){
                ans.add(temp.get(j));
            }
        }
        return ans;
    }
}