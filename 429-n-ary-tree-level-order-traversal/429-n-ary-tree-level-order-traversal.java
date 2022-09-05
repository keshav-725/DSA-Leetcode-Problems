/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> outerlist = new ArrayList<List<Integer>>();
        if(root==null){
            return outerlist;
        }
        Queue<Node> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        outerlist.add(list);
        q.add(root);
        
        while(q.size()>0){
            int size = q.size();
            List<Integer> innerlist = new ArrayList<>();
            while(size>0){
                root = q.remove();
                for(Node children:root.children){
                    innerlist.add(children.val);
                    q.add(children);
                }
                size--;
            }
            if(innerlist.size()>0){
                outerlist.add(innerlist);
            }
        }
        return outerlist;
    }
}