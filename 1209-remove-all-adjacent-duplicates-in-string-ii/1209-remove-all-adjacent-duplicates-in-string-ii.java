class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<Node> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(stack.isEmpty() || stack.peek().c != c) stack.push(new Node(c, 1));
            else stack.push(new Node(c, stack.peek().val + 1));
         
            if(stack.peek().val == k){
                int n = k;
                while(n-- > 0) stack.pop();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop().c);
        return sb.reverse().toString();
    }
    
    class Node{
        char c;
        int val;
        public Node(char c, int val){
            this.c = c;
            this.val = val;
        }
    }
}