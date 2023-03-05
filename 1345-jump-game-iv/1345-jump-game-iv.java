class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> valueIndex = new HashMap();
        int len = arr.length;
        for(int i=0;i<len;i++){
            valueIndex.computeIfAbsent(arr[i], l -> new ArrayList()).add(i);
        }
        boolean[] visited = new boolean[len];
        Queue<Integer> queue = new LinkedList();
        queue.add(0);
        visited[0] = true;
        int jumps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int idx = queue.poll();
                if(idx == len-1)
                    return jumps;
                List<Integer> adjList = valueIndex.get(arr[idx]);
               adjList.add(idx+1);
                adjList.add(idx-1);
                for(int j : adjList){
                    if(j>= 0 && j < len && !visited[j]){
                        queue.add(j);
                        visited[j] = true;
                    }
                }
                adjList.clear();
            }
            jumps++;
        }
        return -1;   
    }
}