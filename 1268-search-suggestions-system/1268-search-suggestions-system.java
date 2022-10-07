class Solution {
    public class Node{
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
            return this.isEnd;
        }
        public void setEnd(){
            this.isEnd = true;
        }
    }
    public void insert(String s,Node curr){
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(curr.contains(ch)==false){
                curr.set(ch);
            }
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    Node root;
    public List<List<String>> suggestedProducts(String[] products, String sword) {
        List<List<String>> ans = new ArrayList<>();
        
        root = new Node();
        for(String s:products){
            Node curr = root;
            insert(s,curr);
        }
        Node curr = root;
        for(int i=0;i<sword.length();i++){
            if(curr==null){
                for(int j=ans.size();j<sword.length();j++){
                    ans.add(new ArrayList<>());
                }
                return ans;
            }
            char ch = sword.charAt(i);
            curr = curr.get(ch);
            Node tcurr = curr;
            String temp = sword.substring(0,i+1);
            List<String> list = new ArrayList<>();
            dfs(tcurr,list,temp);
            ans.add(list);
        }
        return ans;
    }
    public void dfs(Node curr,List<String> list,String s){
        if(list.size()==3 || curr==null) return;
        if(curr.getEnd()==true){
            String temp = s;
            list.add(temp);
        }
        // System.out.println(s);
        for(char chn='a';chn<='z';chn++){
            if(curr.contains(chn)){
                dfs(curr.get(chn),list,s+chn);
            }
        }
    }
}