class MapSum {
    public static class Node{
        private Node []children = new Node[26];
        private int freq = 0;
        private int isEnd=0;
        
        public boolean contains(char ch){
            return (children[ch-'a']!=null);
        }
        
        public Node get(char ch){
            return children[ch-'a'];
        }
        public void set(char ch){
            children[ch-'a']=new Node();
        }
        public int getfreq(){
            return this.freq;
        }
        public void setfreq(int val){
            this.freq+=val;
        }
        public void decreasefreq(int val){
            this.freq-=val;
        }
        public void replacefreq(int val){
            this.freq=val;
        }
        public int getend(){
            return isEnd;
        }
        public void setEnd(int val){
            this.isEnd=val;
        }
    }
    Node root;
    public MapSum() {
        root = new Node();
    }
    
    public void insert(String words, int val) {
        Node curr = root;
        for(int i=0;i<words.length();i++){
            char ch = words.charAt(i);
            if(curr.contains(ch)==false){
                curr.set(ch);
            }
            curr.setfreq(val);
            curr = curr.get(ch);
        }
        if(curr.getend()!=0){
            int value = curr.getend();
            curr = root;
            for(int i=0;i<words.length();i++){
                char ch = words.charAt(i);
                if(curr.contains(ch)==false){
                    curr.set(ch);
                }
                curr.decreasefreq(value);
                curr = curr.get(ch);
            }
            curr.replacefreq(val);
        }else{
            curr.setfreq(val);
            curr.setEnd(val);
        }
    }
    
    public int sum(String prefix) {
        Node curr = root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(curr.contains(ch)==false){
                return 0;
            }
            curr = curr.get(ch);
        }
        return curr.getfreq();
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */