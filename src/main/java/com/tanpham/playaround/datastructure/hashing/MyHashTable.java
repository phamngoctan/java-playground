package com.tanpham.playaround.datastructure.hashing;

import java.util.Arrays;

public class MyHashTable<K, V> {
	
	private int capacity = 16;
	private Entry<K, V>[] buckets;
	
	public MyHashTable() {
		buckets = new Entry[capacity];
	}

	@Override
	public String toString() {
		return "MyHashTable [buckets=" + Arrays.toString(buckets) + "]";
	}

	public void add(K key, V value) {
		// TODO Auto-generated method stub
		buckets[hash(key, capacity)] = new Entry<>(key, value);
	}
	
	public int hash(K key, int sizeOfHashTable) {
		return key.hashCode() % sizeOfHashTable;
	}
	
}
