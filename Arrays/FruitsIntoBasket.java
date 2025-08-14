import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>(); 
        int left = 0, maxFruits = 0;

        for (int right = 0; right < fruits.length; right++) {
            int fruit = fruits[right];

            
            if (basket.containsKey(fruit)) {
                basket.put(fruit, basket.get(fruit) + 1);
            } else {
                basket.put(fruit, 1);
            }

            
            while (basket.size() > 2) {
                int leftFruit = fruits[left];
                basket.put(leftFruit, basket.get(leftFruit) - 1);
                if (basket.get(leftFruit) == 0) {
                    basket.remove(leftFruit);
                }
                left++;
            }

            
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}


