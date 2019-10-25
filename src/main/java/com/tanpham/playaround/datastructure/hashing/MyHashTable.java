package com.tanpham.playaround.datastructure.hashing;

public class MyHashTable<K, V> {
	
	private Entry<K, V>[] buckets;
	
	public MyHashTable() {
		buckets = new Entry[16];
	}

	public void add(K key, V value) {
		// TODO Auto-generated method stub
		buckets[0] = new Entry<>(key, value);
	}
	
	public int hash(K key, int sizeOfHashTable) {
		return key.hashCode() % sizeOfHashTable;
	}
	
}
