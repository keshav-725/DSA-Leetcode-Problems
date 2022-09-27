class Solution {
    class Pair{
        int route;
        int time;
        Pair(int route,int time){
            this.route = route;
            this.time = time;
        }
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        if(source==target) return 0;
        for(int i=0;i<routes.length;i++){
            for(int j=0;j<routes[i].length;j++){
                map.putIfAbsent(routes[i][j],new ArrayList<>());
                map.get(routes[i][j]).add(i);
            }
        }
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(source,1));
        boolean []visited = new boolean[routes.length];
        for(int val : map.get(source)){
            
            if(visited[val]==false){
                visited[val]=true;
                for(int route:routes[val]){
                    queue.addLast(new Pair(route,1));
                }
            }
        }
        while(queue.size()>0){
            Pair rem = queue.removeFirst();
            if(rem.route==target){
                return rem.time;
            }
            for(int val : map.get(rem.route)){
                if(visited[val]==false){
                    visited[val]=true;
                    for(int route:routes[val]){
                        queue.addLast(new Pair(route,rem.time+1));
                    }
                }
            }
        }
        return -1;
    }
}