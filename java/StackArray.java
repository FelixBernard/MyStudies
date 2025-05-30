import javax.management.RuntimeErrorException;

public class StackArray<T> {
    
    @SuppressWarnings("FieldMayBeFinal")
    private T[] stackArray;

    @SuppressWarnings("FieldMayBeFinal")
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

    public boolean isFull() {
        return pointer == size - 1;
    }

    public void push(T key) {
        if (pointer == size - 1) {
            throw new RuntimeErrorException(null, "Stack is full");
        }
        pointer++;
        stackArray[pointer] = key;
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
