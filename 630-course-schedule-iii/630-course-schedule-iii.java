class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum=0,count=0;
        for(int i=0;i<courses.length;i++){
            sum+=courses[i][0];
            pq.add(courses[i][0]);
            if(sum>courses[i][1]){
                sum-= pq.remove();
                count--;
            }
            count++;
        }
        return count;
    }
}