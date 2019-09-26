package com.tanpham.playaround.datastructure;

public class MyLinkedListWithTail<E> {
    private int size = 0;
    private Node<E> head;
    private Node<E> tail;
    
    public int size() {
        return size;
    }

    public Object empty() {
        return true;
    }
    
}
