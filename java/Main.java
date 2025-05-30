
import java.util.Arrays;

public class Main {
    public static void main(String [] args) {

        /*
         * LinkedList Section
         */
        System.out.println("--- LinkedList Section ---");

        MyLinkedListItem<Integer> ll = new MyLinkedListItem<>(1);
        ll.setNext(new MyLinkedListItem<>(2));

        for (MyLinkedListItem<Integer> p = ll; p.getNext() != null; p = p.getNext()) {
            System.out.println(p.getKey());
        }

        System.out.println(ll.getNext().getKey());


        /*
         * Sort Section
         */
        System.out.println("--- Sort Sectin ---");

        Sort<Integer> sortClass = new Sort<>();

        Integer[] bubblelist = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sortClass.bubbleSort(bubblelist);
        System.out.println("BubbleSort: " + Arrays.toString(bubblelist));

        Integer[] insertlist = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sortClass.insertionSort(insertlist);
        System.out.println("InsertionSort: " + Arrays.toString(insertlist));

        Integer[] revInsertlist = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sortClass.reverseInsertionSort(revInsertlist);
        System.out.println("ReverseInsertSort: " + Arrays.toString(revInsertlist));
        
        Integer[] quicklist = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sortClass.quickSort(quicklist, 0, quicklist.length-1);
        System.out.println("QuickSort: " + Arrays.toString(quicklist));

        Integer[] mergelist = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sortClass.mergeSort(mergelist);
        System.out.println("MergeSort: " + Arrays.toString(mergelist));


        /*
         * Search Section
         */
        System.out.println("--- Search Section ---");

        Search<Integer> searchClass = new Search<>();

        Integer[] search = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sortClass.bubbleSort(search);
        System.out.println("Search: " + searchClass.binarySearch(search, 4));


        /*
         * Stack Section
         */
        System.out.println("--- Stack Section ---");
        
        StackHandler<String> stack = new StackHandler<>();
        stack.push("Moin");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}