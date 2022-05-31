class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        HashMap<Character, List<Integer>> positionmap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            // should not be a integer, but a list of integer because of duplicate char exists
            if (!positionmap.containsKey(s.charAt(i))) {
                positionmap.put(s.charAt(i), new ArrayList<Integer>());
            }
            positionmap.get(s.charAt(i)).add(i);
        }
        

        int count = 0;
        for (String w: words) {
            // check every word in the String[]:
            int prev = -1;
            boolean found = false;
            int j = 0;
            outer:
            for (j = 0; j < w.length(); j++) {
                // check every char in the current word w:
                boolean has = false;
                char c = w.charAt(j);
                
                if (positionmap.containsKey(c)) {
                    List<Integer> l = positionmap.get(c);
                    
                    inner:
                    for (int i: l) {
                        if (i > prev) {
                            // means current char c in this word w meets requirement:
                            has = true;
                            prev = i;
                            break inner;
                        }
                    }
                } else {
                    // if char c not found in the map, directly break the word w loop(outter loop)
                    break outer;
                }
                if (has == false) {
                    break outer;
                } else {
                    found = true;
                }
            }
            if (found == true && j == w.length()) {
                // see the j has reach the end of the word,
                // means check if we have checked every char in the word
                count++;
            }

        }
        return count;
    }
}