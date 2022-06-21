class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
    int i=1;
    for(i=1;i<heights.length;i++)
    {
       // System.out.print(bricks+" ");
       if(heights[i-1]>=heights[i])
            continue;
        pq.add(heights[i]-heights[i-1]);
        bricks-=heights[i]-heights[i-1];
        if(bricks>=0)
            continue;
        if(ladders>0)
        {
          bricks+=pq.poll();
          ladders--;
        }
        if(bricks<0 && ladders<=0)
        {
            return i-1;
        }

        
    }
    return i-1;
    }
}