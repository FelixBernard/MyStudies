public class MyDoubleLinkedListItem<T> {
    private T key;

    private MyDoubleLinkedListItem<T> next;

    private MyDoubleLinkedListItem<T> prev;

    public MyDoubleLinkedListItem(T key) {
        this.key = key;
        this.next = null;
    }

    public MyDoubleLinkedListItem(T key, MyDoubleLinkedListItem<T> ll) {
        this.key = key;
        this.next = ll;
    }

    /*
     * Get the key of this item
     */
    public T getKey() {
        return this.key;
    }

    /*
     * Set the key of this item to the parameter key
     */
    public void setKey(T key) {
        this.key = key;
    }

    /*
     * Get the next item
     */
    public MyDoubleLinkedListItem<T> getNext() {
        return next;
    }

    /*
     * Set an next item
     * 
     */
    public void setNext(MyDoubleLinkedListItem<T> next) {
        this.next = next;
    }

    /*
     * Get the next item
     */
    public MyDoubleLinkedListItem<T> getPrev() {
        return prev;
    }

    /*
     * Set an prev item
     */
    public void setPrev(MyDoubleLinkedListItem<T> prev) {
        this.prev = prev;
    }

    /*
     * if the LinkedListItem has an pointer to the next item.
     */
    public boolean hasNext() {
        return this.next != null;
    }
}
