class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int []> pqCap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        PriorityQueue<int []> pqProfit = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for(int i = 0; i < profits.length; i++)
        {
            pqCap.add(new int[]{capital[i], profits[i]});
        }

        while(k > 0)
        {
            while(pqCap.size() > 0 && pqCap.peek()[0] <= w)
            pqProfit.add(pqCap.poll());

            if(pqProfit.size() == 0)
            break;

            w = w + pqProfit.poll()[1];
            k--;
        }
         return w;
    }
}