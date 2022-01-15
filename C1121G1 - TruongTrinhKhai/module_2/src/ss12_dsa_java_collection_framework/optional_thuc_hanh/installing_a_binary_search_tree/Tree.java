package ss12_dsa_java_collection_framework.optional_thuc_hanh.installing_a_binary_search_tree;

public interface Tree<E> {
    public boolean insert(E e);

    public boolean delete(E e);

    public void inOrder();

    public void postOrder();

    public void preOrder();

    public int getSize();
}
