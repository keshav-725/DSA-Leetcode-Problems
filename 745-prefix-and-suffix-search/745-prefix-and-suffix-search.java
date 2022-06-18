class WordFilter {
    HashMap<String,Integer> map;
    public WordFilter(String[] words) {
        map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            String str = words[i];
            for(int j=0;j<str.length();j++){
                for(int k=str.length()-1;k>=0;k--){
                    String pre = str.substring(0,j+1);
                    String suf = str.substring(k);
                    String key = pre+"*"+suf;
                    map.put(key,i);
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        String key = prefix+"*"+suffix;
        return map.getOrDefault(key,-1);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */