class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = width * h;

        
            maxArea = Math.max(maxArea, area);

            
            /*if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }*/
             while (left<right && height[left] <= h) {
                left++;
            }
            while (left<right && height[right] <= h) {
                right--;
            }
        }

        return maxArea;
    }
}
