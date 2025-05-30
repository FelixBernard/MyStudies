public class StackItem<T> {

    private T key;

    private StackItem<T> under;

    public StackItem() {}

    public StackItem(T key) {
        this.key = key;
    }

    public StackItem(StackItem<T> under) {
        this.under = under;
    }

    public StackItem(T key, StackItem<T> under) {
        this.key = key;
        this.under = under;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public StackItem<T> getUnder() {
        return under;
    }

    public void setUnder(StackItem<T> under) {
        this.under = under;
    }

    
}
