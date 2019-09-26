package com.tanpham.playaround.datastructure;

public class MyLinkedListWithTail<E> {
    private int size = 0;
    private Node<E> head;
    private Node<E> tail;
    
    public int size() {
        return size;
    }

    public boolean empty() {
        return true;
    }

    public E valueAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> next = head.next();
        int i = 0;
        while (next != null) {
            if (i == index) {
                return next.value();
            }
            i++;
        }
        return null;
    }
    
}
