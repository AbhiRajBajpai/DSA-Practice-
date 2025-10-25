class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
         int n = fruits.length;
        int unplaced = n; 
        //boolean[] used = new boolean[n]; 

        for (int i = 0; i < n; i++) {
            int fruity = fruits[i];
            for (int j = 0; j < n; j++) {
                if ( baskets[j]!=0 && baskets[j] >= fruity) {
                    baskets[j]=0;
                    unplaced--;
                    break;
                }
            }
        }

        return unplaced;
    }
}