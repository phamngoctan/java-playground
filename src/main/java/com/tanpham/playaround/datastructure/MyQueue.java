package com.tanpham.playaround.datastructure;

/**
 * This kind of data structure can be implemented in two ways.<br/>
 * First one is following the idea of LinkedList which is the list of Node<E> point to next one.
 * The insertion time will cost O(1) <strike>but the search will be linear time O(n), that means dequeue at tail would be O(n) because you'd need the next to last element, 
 * causing a full traversal each dequeue.</strike> <br/>
 * For the O(n) at the dequeue of LinkedList approach, this can be handled by using the pointer of the item before the tail. This will make the time to O(1).
 * <br/>
 * 
 * Secondly, following the idea of Vector to use the dynamic array of items.<br/><br/>
 * 
 * In this class implementation, I would go with option enqueue the new item to the tail.<br/>
 * The dequeue will be beneficial from this step because it takes O(1).
 */
public interface MyQueue<E> {
	public boolean empty();
	public int size();
	public void enqueue(E value);
	public E dequeue();
}
