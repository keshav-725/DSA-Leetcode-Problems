class Solution {
    class TrieNode {
    TrieNode[] children;
    List<String> suggestions;
    
    TrieNode() {
        this.children = new TrieNode[26];
        this.suggestions = new ArrayList<>();
    }
}

public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    
    TrieNode root = new TrieNode();    
    Arrays.sort(products);
    for(String product : products) {
        TrieNode currNode = root;
        
        for(int idx = 0; idx<product.length(); idx++) {
            int charInt = product.charAt(idx) - 'a';
            if(currNode.children[charInt] == null) {
                currNode.children[charInt] = new TrieNode();
            }
            
            currNode = currNode.children[charInt];
            if(currNode.suggestions.size() < 3) {
                currNode.suggestions.add(product);
            }
        }    
    }
    
    List<List<String>> suggestedProductsList = new ArrayList<>();
    for(int idx = 0; idx<searchWord.length(); idx++) {

        int charInt = searchWord.charAt(idx) - 'a';
        if(root.children[charInt] != null) {
            root = root.children[charInt];
            suggestedProductsList.add(root.suggestions);
        } else {
            for(int i = idx; i< searchWord.length(); i++) {
                suggestedProductsList.add(Collections.EMPTY_LIST);
            }
            return suggestedProductsList;
        }
    }
    
    return suggestedProductsList;
}
}

