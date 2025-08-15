class Solution {
    public int longestNiceSubarray(int[] nums) {
       int left=0; int bit=0; int max_len=0;
        for(int right=0; right<nums.length;right ++)
        {
            while((bit & nums[right])!=0)
            {
                bit = bit ^ nums[left];
                left++;
            }
            bit=bit | nums[right];
            max_len=Math.max(max_len , right-left+1);      
        }
        return max_len;
    }
}