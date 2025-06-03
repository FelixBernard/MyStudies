public class BinaryTreeItem<T> {

    private T key;

    private BinaryTreeItem<T> parent;

    private BinaryTreeItem<T> left;

    private BinaryTreeItem<T> right;

    public BinaryTreeItem(T key) {
        this.key = key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public BinaryTreeItem<T> getParent() {
        return parent;
    }

    public void setParent(BinaryTreeItem<T> parent) {
        this.parent = parent;
    }

    public BinaryTreeItem<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeItem<T> left) {
        this.left = left;
    }

    public BinaryTreeItem<T> getRight() {
        return right;
    }

    
}
