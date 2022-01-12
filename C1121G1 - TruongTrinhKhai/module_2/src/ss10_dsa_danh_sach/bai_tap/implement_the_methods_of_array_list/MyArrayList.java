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

    private void ensureCapacity(int minCapacity) {
        int newSize = elements.length + minCapacity;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(int index, E element) {
        if(size == elements.length) {
            ensureCapacity(10);
        } else if (index > size){
            throw new IllegalArgumentException("Index: " + index);
        }

        if (index == size) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size; i > index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
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

    public MyArrayList<E> clone() {
        MyArrayList<E> newElements = new MyArrayList<>();
        newElements.elements = Arrays.copyOf(elements, size);
        newElements.size = this.size;
        return newElements;
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

    public boolean add(E e) {
        add(size, e);
        return true;
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
