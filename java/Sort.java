import java.util.concurrent.TimeUnit;

public class Sort<T extends Comparable<T>> {

    public Sort() {}

    public void bubbleSort(T[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i ; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    T tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public void insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i-1;
            // System.out.print("\033[1A\033[2K");
            // System.out.println(Arrays.toString(arr));
            while (j >= 0 && key.compareTo(arr[j]) < 0) {
                // System.out.print("\033[1A\033[2K");
                // System.out.println(Arrays.toString(arr));
                // sleep(1000);
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public void reverseInsertionSortBordered(T[] arr, int left, int right) {
        for (int i = right - 1; i >= left; i--) {
            T key = arr[i];
            int j = i+1;
            while (j <= right && key.compareTo(arr[j]) > 0) {
                arr[j-1] = arr[j];
                j++;
            }
            arr[j-1] = key;
        }
    }

    public void reverseInsertionSort(T[] arr) {
        reverseInsertionSortBordered(arr, 0, arr.length-1);
    }

    public void quickSort(T[] arr, int left, int right) {
        // int p = doPivot(arr, left, right);
        // quickSort(arr, left, p);
        // quickSort(arr, p+1, right);
        
    }

    public void mergeSort(T[] arr) {
        // System.out.println("merge");
    }

    public void bucketSort(T[] arr) {
        System.out.println("bucket");
    }

    public int doPivot(T[] arr, int left, int right) {
        T pivot = arr[left];
        int p = left - 1;
        int q = right + 1;

        while (p < q) {
            do {
                p++;
            }
            // REPEAT p = p + 1 UNTIL A[p] >= pivot; // left up
            while (arr[p].compareTo(pivot) < 0);
            do {
                q--;
            }
            // REPEAT q = q - 1 UNTIL A[p] <= pivot; // left up
            while (arr[q].compareTo(pivot) > 0);
            if (p < q) {
                // swap
                T tmp = arr[p];
                arr[p] = arr[q];
                arr[q] = tmp;
            }
        }

        return q;
    }

    public void sleep(long milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Sleep interrupted: " + e.getMessage());
        }
    }
}
