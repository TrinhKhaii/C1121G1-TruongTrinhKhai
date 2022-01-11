package ss10_dsa_danh_sach.bai_tap.implement_the_methods_of_array_list;

import java.util.Arrays;

public class MyArrayList<E> {
    private int size;
    static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        elements = new Object[capacity];
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(int index, E element) {
        if(size == elements.length) {
            ensureCapa();
        }
        for (int i = size; i > index; i++) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public E remove(int index) {
        for(int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return (E) elements[index];
    }

    public int getSize() {
        return size;
    }

    // hoi thay
    public E clone() {
        Object newElements = new Object[elements.length];
        newElements = Arrays.copyOf(elements, size);
        return (E) newElements;
    }

    public boolean contains(E o) {
        for(int i = 0; i < size; i++) {
            if(elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    //hoi thay
    public boolean add(E e) {
        return true;
    }

    //hoi thay
    public void ensureCapacity(int minCapacity) {
    }

    public void clear() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + i);
        }
        return (E) elements[i];
    }
}
