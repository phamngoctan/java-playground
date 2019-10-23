package com.tanpham.playaround.datastructure.hashing;

public class MyHashTable<K, V> {
	
	private Entry<K, V>[] buckets;
	
	@SuppressWarnings("unchecked")
	public MyHashTable() {
		buckets = (Entry<K, V>[]) new Object[16];
	}

	public void put(K key, V value) {
		// TODO Auto-generated method stub
		buckets[0] = new Entry<>(key, value);
	}
	
}
