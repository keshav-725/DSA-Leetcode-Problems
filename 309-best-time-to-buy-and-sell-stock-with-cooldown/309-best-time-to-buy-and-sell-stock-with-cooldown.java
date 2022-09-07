class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int obp = -prices[0];
        int osp = 0;
        int ocp = 0;
        for(int i=1;i<n;i++){
            int nbp = Math.max(ocp-prices[i],obp);
            int nsp = Math.max(obp+prices[i],osp);
            
            ocp = Math.max(osp,ocp);
            
            obp = nbp;
            osp = nsp;
        
        }
        return osp;
    }
}