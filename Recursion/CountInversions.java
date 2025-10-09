class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[], int N) {
        return mergeSortAndCount(arr, 0, N - 1);
    }

    // Recursive merge sort function that returns inversion count
    static int mergeSortAndCount(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            // Count inversions in left half
            count += mergeSortAndCount(arr, left, mid);

            // Count inversions in right half
            count += mergeSortAndCount(arr, mid + 1, right);

            // Count cross inversions between halves
            count += mergeAndCount(arr, left, mid, right);
        }
        return count;
    }

    // Merging two halves and counting split inversions
    static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        int swaps = 0;

        // Merge and count inversions
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                // All remaining elements in leftArr[i..end] form inversions
                swaps += (n1 - i);
            }
        }

        // Copy remaining elements (if any)
        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];

        return swaps;
    }
}
