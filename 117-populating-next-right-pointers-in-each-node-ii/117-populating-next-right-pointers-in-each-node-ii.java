/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        LinkedList<Node> pq = new LinkedList<>();
        pq.add(root);
        while(pq.size()>0){
            int size=pq.size();
            int tsize = size;
            Node prev=null,rm=null;
            while(size>0){
                prev=rm;
                rm = pq.removeFirst();
                if(prev!=null){
                    prev.next=rm;
                }
                if(rm.left!=null) pq.addLast(rm.left);
                if(rm.right!=null) pq.addLast(rm.right);
                size--;
            }
        }
        return root;
    }
}