class StreamChecker {
    public class Node{
        Node []children = new Node[26];
        boolean isEnd=false;
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
        public void setEnd(){
            this.isEnd = true;
        }
    }
    StringBuilder sb;
    Node root;
    public void insert(String s,Node curr){
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(curr.contains(ch)==false){
                curr.set(ch);
            }
            curr = curr.get(ch);
        }
        curr.setEnd();
    }

    public StreamChecker(String[] words) {
        root = new Node();
        sb = new StringBuilder("");
        for(String s : words){
            Node curr = root;
            insert(s,curr);
        }
    }
    
    public boolean query(char letter) {
        sb.insert(0,letter);
        Node curr = root;
        
        return isp(sb.toString(),curr,0);
    }
    public boolean isp(String s,Node curr,int idx){
        if(curr==null) return false;
        if(idx==s.length()){
            if(curr.getEnd()==true) return true;
            return false;
        }
        if(curr.getEnd()==true) return true;
        char ch = s.charAt(idx);
        
        if(isp(s,curr.get(ch),idx+1)) return true;
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */