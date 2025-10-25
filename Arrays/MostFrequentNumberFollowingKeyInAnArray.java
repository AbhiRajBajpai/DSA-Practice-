import java.util.*;

class Solution {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                int next = nums[i + 1];
                if (map.containsKey(next)) {
                    map.put(next, map.get(next) + 1);
                } else {
                    map.put(next, 1);
                }
            }
        }

        
        int maxCount = 0;
        int result = -1;

        
        List<Integer> keys = new ArrayList<>(map.keySet());
        for (int i = 0; i < keys.size(); i++) {
            int num = keys.get(i);
            int count = map.get(num);
            if (count > maxCount) {
                maxCount = count;
                result = num;
            }
        }

        return result;
    }
}
