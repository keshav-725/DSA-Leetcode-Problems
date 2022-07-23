class Solution {
    public int[] findOrder(int numcourses, int[][] pre) {
        ArrayList<Integer>[] list = new ArrayList[numcourses];
        for(int i=0;i<numcourses;i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<pre.length;i++){
            int []temp = pre[i];
            list[temp[1]].add(temp[0]);
        }
        int []in = new int[numcourses];
        for(int i=0;i<numcourses;i++){
            for(int n : list[i]){
                in[n]++;
            }
        }
        int length = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0;i<numcourses;i++){
            if(in[i]==0){
                queue.addLast(i);
            }
        }
        int []ans = new int[numcourses];
        while(queue.size()>0){
            Integer rem = queue.removeFirst();
            ans[length] = rem;
            length++;
            for(int n : list[rem]){
                in[n]--;
                if(in[n]==0){
                    queue.addLast(n);
                }
            }
        }
        if(length==numcourses) return ans;
        return new int[]{};
    }
}