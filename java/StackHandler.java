import javax.management.RuntimeErrorException;

public class StackHandler<T> {
    
    private StackItem<T> top;

    public StackHandler() {}

    public StackItem<T> getTop() {
        return top;
    }

    public void setTop(StackItem<T> top) {
        this.top = top;
    }

    public boolean isEmpty() {
        return top == null;
    }

    /*
     * Puts an new T Object on the stack
     */
    public void push(T key) {
        StackItem<T> newTop = new StackItem<>();
        newTop.setKey(key);
        newTop.setUnder(top);
        top = newTop;
    }

    /*
     * Pops the object on from the top of the stack
     */
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeErrorException(null, "Stack is empty");
        }
        T key = top.getKey();
        top = top.getUnder();
        return key;
    }

}
