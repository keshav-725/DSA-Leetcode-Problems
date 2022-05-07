class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<routes.length;i++){
            for(int j=0;j<routes[i].length;j++){
                map.putIfAbsent(routes[i][j],new ArrayList<Integer>());
                map.get(routes[i][j]).add(i);
            }
        }
        //System.out.println(map);
        HashSet<Integer> busstop = new HashSet<>();
        HashSet<Integer> busno = new HashSet<>();
        
        LinkedList<Integer> queue = new LinkedList<>();
        int level = -1;
        queue.add(source);
        
        while(queue.size()>0){
            level++;
            int s = queue.size();
            while(s-->0){
                int rem = queue.removeFirst();
                if(rem==target){
                    return level;
                }
                for(int busnum : map.get(rem)){
                    if(busno.contains(busnum)){
                        continue;
                    }else{
                        for(int busstand : routes[busnum]){
                            if(busstop.contains(busstand)==false){
                                busstop.add(busstand);
                                queue.addLast(busstand);
                            }
                        }
                        busno.add(busnum);
                    }
                }
            }
        }
        return -1;
    }
}