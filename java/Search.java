public class Search<T extends Comparable<T>> {

    public Search() {}

    public int binarySearch(T[] arr, T key) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = l + ((r - l) / 2);
            if (arr[m].compareTo(key) == -1) {
                l = m + 1;
            }
            else if (arr[m].compareTo(key) == 1) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return -1;
        
    }
}
