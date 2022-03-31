class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        
        HashMap<String,Integer> map = new HashMap<>();
        
        int n = cpdomains.length;
        for(int i=0;i<n;i++){
            String[] domain = cpdomains[i].split(" ");
            int count = Integer.parseInt(domain[0]);
            
            map.put(domain[1],map.getOrDefault(domain[1],0)+count);
            
            int len = domain[1].length();
            
            for(int j=0;j<len;j++){
                if(domain[1].charAt(j)=='.'){
                    String str = domain[1].substring(j+1,len);
                    map.put(str,map.getOrDefault(str,0)+count);
                }
            }
        }
        for(String key : map.keySet()){
            String str = map.get(key)+" "+key;
            list.add(str);
        }
        return list;
    }
}