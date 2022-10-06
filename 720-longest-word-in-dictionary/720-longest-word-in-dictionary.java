class Solution {
    class Node{
        Node []children = new Node[26];
        boolean isEnd = false;
        
        public boolean contains(char ch){
            return (children[ch-'a']!=null);
        }
        public Node get(char ch){
            return children[ch-'a'];
        }
        public void set(char ch){
            children[ch-'a'] = new Node();
        }
        public boolean getEnd(){
            return isEnd;
        }
        public void setEnd(){
            this.isEnd = true;
        }
    }
    Node root;
    String ans;
    public String longestWord(String[] words) {
        root = new Node();
        ans="";
        
        for(int i=0;i<words.length;i++){
            Node curr = root;
            for(int j=0;j<words[i].length();j++){
                char ch = words[i].charAt(j);
                if(curr.contains(ch)==false){
                    curr.set(ch);
                }
                curr = curr.get(ch);
            }
            curr.setEnd();
        }
        
        for(char ch='a';ch<='z';ch++){
            Node curr = root;
            if(curr.contains(ch)){
                dfs(curr.get(ch),ch+"");
            }
        }
        return ans;
    }
    public void dfs(Node curr,String res){
        if(curr.getEnd()==false) return;
        if(curr.getEnd()){
            if(ans.length()<res.length()){
                ans = res;
            }
        }
        for(char ch='a';ch<='z';ch++){
            if(curr.contains(ch)){
                dfs(curr.get(ch),res+ch);
            }
        }
    }
}