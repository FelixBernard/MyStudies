public class BinaryTreeHandler<T> {
    
    private BinaryTreeItem<T> root;

    public void insert(T key) {
        BinaryTreeItem<T> newLeef = new BinaryTreeItem<>(key);
        BinaryTreeItem<T> parent = getParent();
        parent.setLeft(newLeef);
    }

    public BinaryTreeItem<T> getParent() {
        return root;
    }

    public BinaryTreeItem<T> search() {
        return root;
    }

}
