class Solution {
    public boolean canFinish(int courses, int[][] pre) {
        ArrayList<Integer>[] list = new ArrayList[courses];
        for(int i=0;i<courses;i++){
            list[i] = new ArrayList<>();
        }
        for(int []arr : pre){
            int left = arr[0];
            int right = arr[1];
            
            list[right].add(left);
        }
        int []in = new int[courses];
        for(int i=0;i<list.length;i++){
            for(int val : list[i]){
                in[val]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0;i<courses;i++){
            if(in[i]==0) queue.addLast(i);
        }
        int count=0;
        while(queue.size()>0){
            int rem = queue.removeFirst();
            count++;
            for(int val : list[rem]){
                in[val]--;
                if(in[val]==0) queue.addLast(val);
            }
        }
        if(count<courses) return false;
        return true;
    }
}