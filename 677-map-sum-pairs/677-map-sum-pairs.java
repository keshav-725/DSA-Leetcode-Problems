class MapSum {
    class Node{
        Node []children = new Node[26];
        int sum = 0;
        int isEnd = 0;
        public boolean contains(char ch){
            return (children[ch-'a']!=null);
        }
        public Node get(char ch){
            return children[ch-'a'];
        }
        public void set(char ch){
            children[ch-'a'] = new Node();
        }
        public int getSum(){
            return sum;
        }
        public void setSum(int val){
            sum = sum+val;
        }
        public void replaceSum(int val){
            sum = val;
        }
        public int getEnd(){
            return isEnd;
        }
        public void setEnd(int val){
            isEnd=val;
        }
    }
    Node root;
    public MapSum() {
        root = new Node();
    }
    
    public void insert(String word, int val) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            curr.setSum(val);
            if(curr.contains(ch)==false){
                curr.set(ch);
            }
            curr = curr.get(ch);
        }
        curr.setSum(val);
        if(curr.getEnd()>0){
            int tval = curr.getEnd();
            curr=root;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                curr.setSum(-tval);
                curr = curr.get(ch);
            }
            curr.setSum(-tval);
            curr.setEnd(val);
        }else{
            curr.setEnd(val);
        }
    }
    
    public int sum(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.contains(ch)==false){
                return 0;
            }
            curr = curr.get(ch);
        }
        return curr.getSum();
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */