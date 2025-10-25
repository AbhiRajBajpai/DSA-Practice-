class Solution {
    public ArrayList<Integer> intersect(int[] a, int[] b) {
        // code here
        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            set1.add(a[i]);
        }

        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < b.length; i++) {
            if (set1.contains(b[i])) {
                set2.add(b[i]);
            }
        }

         ArrayList<Integer> res = new ArrayList<>(set2);
       // Collections.sort(res);
        return res;
    }
}