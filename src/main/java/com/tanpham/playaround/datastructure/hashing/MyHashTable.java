package com.tanpham.playaround.datastructure.hashing;

import java.util.Arrays;

public class MyHashTable<K, V> {
	
	private int capacity = 4;
	private int size = 0;
	private Entry<K, V>[] buckets;
	
	public MyHashTable() {
		buckets = new Entry[capacity];
	}

	@Override
	public String toString() {
		return "MyHashTable [buckets=" + Arrays.toString(buckets) + "]";
	}

	public void add(K key, V value) {
		buckets[hash(key, capacity - 1)] = new Entry<>(key, value);
		size++;
		if (size >= capacity) {
			throw new RuntimeException("not support");
		}
	}
	
	public int hash(K key, int sizeOfHashTable) {
		return key.hashCode() % sizeOfHashTable;
	}
	
}
