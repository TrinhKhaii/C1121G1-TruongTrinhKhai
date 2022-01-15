package ss12_dsa_java_collection_framework.optional_bai_tap.install_postorder_browsing_in_binary_search_tree;

import ss12_dsa_java_collection_framework.optional_thuc_hanh.installing_a_binary_search_tree.BST;

public class TestPostOrder {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(27);
        tree.insert(14);
        tree.insert(10);
        tree.insert(19);
        tree.insert(35);
        tree.insert(31);
        tree.insert(42);
        System.out.println("Post-order sort: ");
        tree.postOrder();
    }
}
