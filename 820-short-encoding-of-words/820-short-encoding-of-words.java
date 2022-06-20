class Solution {
    public int minimumLengthEncoding(String[] words) {
        
        StringBuilder sb = new StringBuilder();
        
        Arrays.sort(words, (a,b) -> Integer.compare(a.length(), b.length()));
        
        for(int i  = words.length - 1; i >= 0; i--){
            if(sb.toString().indexOf(words[i]) == -1){
                sb.append(words[i]);
                sb.append("#");
            } else if(sb.length() > 0 && sb.toString().indexOf(words[i]) != -1){
            	
            	int idx = sb.indexOf(words[i]);
            	while(idx < sb.indexOf(words[i], idx+1)) {
            	     idx = sb.indexOf(words[i], idx+1);
            	}
            	
            	if(sb.charAt(idx + words[i].length()) != '#') {
	                sb.append(words[i]);
	                sb.append("#");
            	}
            }
        }
        
        return sb.toString().length();
    }
}