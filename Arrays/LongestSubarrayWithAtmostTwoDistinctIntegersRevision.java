class Solution {
    public int totalElements(int[] arr) {
        // code here
         int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++) {
            int num = arr[right];
            map.put(num, map.getOrDefault(num, 0) + 1);

            while (map.size() > 2) {
                int leftNum = arr[left];
                map.put(leftNum, map.get(leftNum) - 1);
                if (map.get(leftNum) == 0) {
                    map.remove(leftNum);
                }
                left++;
            }

            
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}