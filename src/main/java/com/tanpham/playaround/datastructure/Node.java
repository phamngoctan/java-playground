package com.tanpham.playaround.datastructure;

public class Node<E> {
    Node<E> next;
    E value;
    
    public Node(E value) {
        this.value = value;
    }
}
