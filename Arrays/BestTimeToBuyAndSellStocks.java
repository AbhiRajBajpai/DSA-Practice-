class Solution {
    public int maxProfit(int[] prices) {
      int i=0; int min=prices[i]; int profit=0;
      for(i=1;i<prices.length;i++)
      {
        if(min>prices[i])
        {
            min=prices[i];
        }
        else{
            profit=Math.max(profit,(prices[i]-min));

        }
      }
      return profit;
    }
}