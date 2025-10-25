import java.util.*;

class Solution {
    public List<Integer> findLonely(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!set.add(num)) {
                duplicates.add(num);
            }
        }

        List<Integer> result = new ArrayList<>();

       
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!duplicates.contains(num) && !set.contains(num - 1) && !set.contains(num + 1)) {
                result.add(num);
            }
        }

        return result;
    }
}
