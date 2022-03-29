class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        HashMap<String,PriorityQueue<String>> map = new HashMap<>();
        Stack<String> st = new Stack<>();
        
        for(int i=0;i<tickets.size();i++){
            String str = tickets.get(i).get(0);
            if(!map.containsKey(str)){
                map.put(str,new PriorityQueue<String>());
            }
            map.get(str).add(tickets.get(i).get(1));
        }
        List<String> list = new ArrayList<>();
        st.add("JFK");
        while(!st.empty()){
            while(map.containsKey(st.peek()) && !map.get(st.peek()).isEmpty()){
                st.push(map.get(st.peek()).poll());
            }
            list.add(0,st.pop());
        }
        return list;
    }
}