class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] list= new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            int second = prerequisites[i][0];
            int first = prerequisites[i][1];
            
            list[first].add(second);
        }
        int []in = new int[numCourses];
        
        for(int i=0;i<numCourses;i++){
            for(int val : list[i]){
                in[val]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int []ans = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(in[i]==0){
                queue.addLast(i);
            }
        }
        int count  = 0;
        while(queue.size()>0){
            int rem = queue.removeFirst();
            ans[count++] = rem;            
            for(int val : list[rem]){
                in[val]--;
                if(in[val]==0) queue.addLast(val);
            }
        }
        if(count<numCourses) return new int[]{};
        return ans;
    }
}