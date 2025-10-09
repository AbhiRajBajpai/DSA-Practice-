import java.util.Arrays;

public class MergeSortStrings {
    
    // Function to merge two sorted halves
    public static void merge(String[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; // size of left half
        int n2 = right - mid;    // size of right half

        // Temporary arrays
        String[] leftArr = new String[n1];
        String[] rightArr = new String[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];

        // Merge the temporary arrays back into arr
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            // Compare strings lexicographically (alphabetical order)
            if (leftArr[i].compareTo(rightArr[j]) <= 0) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements if any
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    // Recursive merge sort function
    public static void mergeSort(String[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort both halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Main function
    public static void main(String[] args) {
        String[] arr = {"banana", "apple", "grape", "cherry", "mango"};
        
        System.out.println("Original array: " + Arrays.toString(arr));

        // Apply merge sort
        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
