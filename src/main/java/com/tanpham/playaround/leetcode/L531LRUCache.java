package com.tanpham.playaround.leetcode;

import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;

public class L531LRUCache {
	
	@Test
	public void first_test() {
		LRUCache lruCache = new LRUCache(2);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		assertThat(lruCache.get(1), Matchers.equalTo(1));
		lruCache.put(3, 3);
		assertThat(lruCache.get(2), Matchers.equalTo(-1));
		lruCache.put(4, 4);
		assertThat(lruCache.get(1), Matchers.equalTo(-1));
		assertThat(lruCache.get(3), Matchers.equalTo(3));
		assertThat(lruCache.get(4), Matchers.equalTo(4));
	}
	
}

class LRUCache {

	class Node {
		Node pre;
		Node next;
		int key;
		int val;
		@Override
		public String toString() {
			return "Node [key=" + key + ", val=" + val + "]";
		}
	}
	
	int capacity;
	private Map<Integer, Node> cache = new HashMap<>();
	private Node head;
	
	public LRUCache(int capacity) {
        this.capacity = capacity;
    }
	
	private Node getTail() {
		Node node = head;
		while (node.next != null) {
			node = node.next;
		}
		return node;
	}
	
	// always add to the head
	private void add(int key, int value) {
		Node node = new Node();
		node.key = key;
		node.val = value;

		if (head != null) {
			head.pre = node;
			node.next = head;
		}
		head = node;
		
		cache.put(key, node);
	}
	
	private void moveToHead(Node node) {
		if (node == head) {
			return;
		}
		
		delete(node);
		
		node.next = head;
		head.pre = node;
		head = node;
	}

	private void delete(Node node) {
		// delete node
		if (node.pre != null) {
			node.pre.next = node.next;
		} else {
			head = node.next;
		}
		
		if (node.next != null) {
			node.next.pre = node.pre;
		} else {
			// handle tail
		}
	}
	
    public int get(int key) {
    	Node node = cache.get(key);
        if (node == null) {
        	return -1;
        }
        
        moveToHead(node);
        
        return node.val;
    }
    
	public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
        	add(key, value);
        } else {
        	node.val = value;
        	moveToHead(node);
        }
        
        if (cache.size() > capacity) {
    		cache.remove(getTail().key);
			delete(getTail());
    	}
    }
}