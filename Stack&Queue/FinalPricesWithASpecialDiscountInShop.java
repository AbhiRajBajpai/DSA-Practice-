class Solution 
{
    public int[] finalPrices(int[] prices)
    {
        int n= prices.length;
        int[] answer=new int[n];
        Stack<Integer> stack=new Stack<>();
        stack.push(prices[n-1]);
        answer[n-1]=prices[n-1];
        for (int i = n-2; i >= 0;i--)
        {
            while (!stack.isEmpty() && stack.peek()>prices[i])
            {
                stack.pop();
            }
            if (stack.isEmpty())
            {
                answer[i]=prices[i];
            }
            else
            {
                answer[i]=prices[i]-stack.peek();
            }
            stack.push(prices[i]);
        }
        return answer;
    }
}