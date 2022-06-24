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
    public void insert(String word,Node curr){
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.contains(ch)==false){
                curr.set(ch);
            }
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    public String checkPrefix(String word,Node curr){
        for(int j=0;j<word.length();j++){
            char ch = word.charAt(j);
            if(curr.getEnd()==true){
                return word.substring(0,j);
            }
            if(curr.contains(ch)==false){
                return word;
            }
            curr = curr.get(ch);
        }
        return word;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] str = sentence.split(" ");
        Node root = new Node();
        for(int i=0;i<dictionary.size();i++){
            insert(dictionary.get(i),root);
        }
        String []ans = new String[str.length];
        for(int i=0;i<str.length;i++){
            String s = checkPrefix(str[i],root);
            ans[i]=s;
        }
        String value = String.join(" ",ans);
        return value;
    }
}