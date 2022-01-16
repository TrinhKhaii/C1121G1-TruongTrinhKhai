package ss12_dsa_java_collection_framework.optional_thuc_hanh.installing_a_binary_search_tree;

public class TestBST {
    public static void main(String[] args) {
        BST<String> tree = new BST<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        System.out.println("Inorder sort: ");
        tree.inOrder();
        System.out.println("Number of node: " + tree.getSize());

    }
}
