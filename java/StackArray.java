import javax.management.RuntimeErrorException;

public class StackArray<T> {
    
    private T[] stackArray;

    private int size;

    private int pointer = -1;

    @SuppressWarnings("unchecked")
    public StackArray(int size) {
        this.size = size;
        stackArray = (T[]) new Object[size];
    }

    public T[] getArray() {
        return stackArray;
    }

    public boolean isEmpty() {
        return pointer == -1;
    }

    public void push(T key) {
        if (pointer == size) {
            throw new RuntimeErrorException(null, "Stack is full");
        }
        stackArray[pointer] = key;
        pointer++;
    }

    public T pop() {
        if (pointer == -1) {
            throw new RuntimeErrorException(null, "Stack is empty");
        }
        T key = stackArray[pointer];
        stackArray[pointer] = null;
        pointer--;
        return key;
    }


}
