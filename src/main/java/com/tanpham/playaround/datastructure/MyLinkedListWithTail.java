package com.tanpham.playaround.datastructure;

public class MyLinkedListWithTail<E> {
    private int size = 0;
    private Node<E> head;
    private Node<E> tail;
    
    private class Node<E> {
        Node<E> next;
        E value;
        
        public Node(E value) {
            this.value = value;
        }
    }
    
    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public E valueAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> next = head;
        int i = 0;
        while (next != null) {
            if (i == index) {
                return next.value;
            }
            i++;
            next = next.next;
        }
        return null;
    }

    public void pushFront(E value) {
        Node<E> newNode = new Node<>(value);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        
        size++;
    }
    
}
