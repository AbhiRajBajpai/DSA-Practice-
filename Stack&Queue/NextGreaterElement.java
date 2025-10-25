class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n=arr.length;
         Stack<Integer> st = new Stack<>();
        int[] temp= new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) temp[i] = -1;
            else temp[i] = st.peek();
            st.push(arr[i]);
        }
         ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(temp[i]);
        }

        return res;
    }
}