class Solution {
    public static class Node{
        private Node []children = new Node[26];
        private boolean isEnd=false;
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
            return this.isEnd;
        }
        
        public void setEnd(boolean isEnd){
            this.isEnd = isEnd;
        } 
    }
    public String max;
    public void insert(String str,Node curr){
        for(int j=0;j<str.length();j++){
            char ch = str.charAt(j);
            if(curr.contains(ch)==false){
                curr.set(ch);
            }
            curr = curr.get(ch);
        }
        curr.setEnd(true);
    }
    public String longestWord(String[] words) {
        Node root = new Node();
        for(int i=0;i<words.length;i++){
            String str = words[i];
            insert(str,root);
        }
        max = "";
        Node curr = root;
        dfs(curr,"");
        return max;
    }
    public void dfs(Node curr,String res){
        if(res.equals("")==false && curr.getEnd()==false) return;
        if(max.length()<res.length()){
            max=res;
        }
        for(char ch='a';ch<='z';ch++){
            if(curr.contains(ch)){
                dfs(curr.get(ch),res+ch);
            }
        }
    }
}