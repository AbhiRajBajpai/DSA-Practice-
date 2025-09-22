class Solution {
    public int josephus(int n, int k) {
        // code here
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + k) % i;
        }
        return result +1;
    }
}