import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        
        
        for (int i = 2 * n - 1; i >= 0; i--) {
            int curr = nums[i % n];
            
            while (!st.isEmpty() && curr >= nums[st.peek()])
                st.pop();
            
            if (i < n)
                res[i] = st.isEmpty() ? -1 : nums[st.peek()];
           
            st.push(i % n);
        }
        return res;
    }
}
