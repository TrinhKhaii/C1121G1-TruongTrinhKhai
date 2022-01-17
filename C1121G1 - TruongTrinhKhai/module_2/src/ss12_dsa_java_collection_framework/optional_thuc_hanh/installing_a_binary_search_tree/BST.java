package ss12_dsa_java_collection_framework.optional_thuc_hanh.installing_a_binary_search_tree;

import ss11_dsa_stack_queue.optional_bai_tap.demerging_using_queue.Person;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }

    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            insert(objects[i]);
        }
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public boolean insert(E e) {
        if (root == null) {
            root = createNewNode(e);
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0){
                    parent = current;
                    current = current.right;
                } else {
                    return false;
                }
            }
            if (e.compareTo(parent.element) < 0) {
                parent.left = createNewNode(e);
            } else {
                parent.right = createNewNode(e);
            }
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(E e) {
        int size = getSize();
        root = remove(e, root);
        if (getSize() == size) {
            return false;
        } else {
            return true;
        }
    }

    public TreeNode<E> remove(E e, TreeNode<E> root) {
        if (root == null) return root;
        else if (e.compareTo(root.element) < 0) root.left = remove(e, root.left);
        else if (e.compareTo(root.element) > 0) root.right = remove(e, root.right);
        else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else if (root.left != null && root.right == null) {
                return root.left;
            } else {
                root.element = findMin(root.right).element;
                root.right = remove(root.element, root.right);
            }
            size--;
//            return root; ( đệ quy dòng 63, 64 không biết trả về cái gì) -> sai
        }
        return root;
    }

    public TreeNode<E> findMin(TreeNode<E> root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    @Override
    public TreeNode<E> search(E e) {
        return search(e, root);
    }

    public TreeNode<E> search(E e, TreeNode<E> root) {
        if (root == null || e.compareTo(root.element) == 0)  {
            return root;
        }
        if (e.compareTo(root.element) > 0) {
            return search(e, root.right);
        }
        return search(e, root.left);
    }


    @Override
    public int getSize() {
        return size;
    }

    protected void inOrder(TreeNode<E> root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.element + " ");
        inOrder(root.right);
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }

    protected void postOrder(TreeNode<E> root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.element + " ");
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }

    protected void preOrder(TreeNode<E> root) {
        if (root == null) return;
        System.out.println(root.element + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    @Override
    public void preOrder() {
        preOrder(root);
    }
}
