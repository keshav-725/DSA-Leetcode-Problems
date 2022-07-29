class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        ArrayList<String> list=new ArrayList();
        for(int i=0;i<words.length;i++)
        {
            HashMap<Character,Character> map=new HashMap();
            String s =words[i];
            list.add(words[i]);
            for(int j=0;j<s.length();j++)
            {   
                
                if(!map.containsKey(pattern.charAt(j)))
                {   
                    if(map.containsValue(s.charAt(j)))
                    {  
                         list.remove(words[i]);
                        break;
                    }
                    map.put(pattern.charAt(j),s.charAt(j));
                }
                else if(map.get(pattern.charAt(j))!=s.charAt(j))
                {   
                    list.remove(words[i]);
                    break;
                }
                
            }
            
        }
        return list;
    }
}