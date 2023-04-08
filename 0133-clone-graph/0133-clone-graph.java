/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Integer,Node> map = new HashMap<>();
        return helper(node,map);
        
    }
    public Node helper(Node node,HashMap<Integer,Node> map){
        Node nodeclone = new Node(node.val);
        map.put(node.val,nodeclone);
        for(Node nbr : node.neighbors){
            if(map.containsKey(nbr.val)==false){
                Node nbrclone = helper(nbr,map);
                nodeclone.neighbors.add(nbrclone);
            }else{
                Node nbrclone = map.get(nbr.val);
                nodeclone.neighbors.add(nbrclone);
            }
        }
        return nodeclone;
    }
}