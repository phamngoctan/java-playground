package com.tanpham.playaround.datastructure;

public class Node<E> {
    private Node<E> next;
    private E value;
    
    public Node<E> next() {
        return next;
    }
    
    public void setNext(Node<E> nextNode) {
        this.next = nextNode;
    }
    
    public void setValue(E value) {
        this.value = value;
    }
    
    public E value() {
        return value;
    }
}
