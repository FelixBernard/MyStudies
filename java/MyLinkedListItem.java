public class MyLinkedListItem<T> {

    private T key;

    private MyLinkedListItem<T> next;

    public MyLinkedListItem(T key) {
        this.key = key;
        this.next = null;
    }

    public MyLinkedListItem(T key, MyLinkedListItem<T> ll) {
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
    public MyLinkedListItem<T> getNext() {
        return next;
    }

    /*
     * Set an next item
     * 
     */
    public void setNext(MyLinkedListItem<T> next) {
        this.next = next;
    }

    /*
     * if the LinkedListItem has an pointer to the next item.
     */
    public boolean hasNext() {
        return this.next != null;
    }
}

