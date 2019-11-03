package com.tanpham.playaround.datastructure.hashing;

import java.util.Arrays;

public class MyHashTable<K, V> {
	
	private int capacity = 16;
	private int size = 0;
	private Entry<K, V>[] buckets;
	
	public MyHashTable() {
		buckets = new Entry[capacity];
	}

	@Override
	public String toString() {
		return "MyHashTable [buckets=" + Arrays.toString(buckets) + "]";
	}

	//TODO: handle case null key
	public void add(K key, V value) {
		Entry<K, V> entry = new Entry<>(key, value);
		int index = indexFor(key, capacity - 1);
		System.out.println(index);
		
		Entry<K, V> next = buckets[index];
		boolean isKeyExisted = false;
		while (next != null && isKeyExisted == false) {
			if (key.equals(next.getKey())) {
				next.setValue(value);
				isKeyExisted = true;
			}
			next = next.getNext();
		}
		if (!isKeyExisted) {
			entry.setNext(buckets[index]);
		}
		
		buckets[index] = entry;
		size++;
		if (size >= capacity) {
			throw new RuntimeException("not support");
		}
	}
	
	public int indexFor(K key, int capacity) {
		int maximumNumberOfSignedInteger = 0x7fffffff;
		int hashCode = key == null ? 0 : key.hashCode();
		int maskOutTheSignedBitFromAnyValueToZero = hashCode & maximumNumberOfSignedInteger;
		// More effective than the modulus %
		return maskOutTheSignedBitFromAnyValueToZero & capacity;
	}

	public V get(K key) {
		int index = indexFor(key, capacity - 1);
		Entry<K, V> next = buckets[index];
		while (next != null) {
			if (key == next.getKey() || key.equals(next.getKey())) {
				return next.getValue();
			}
			next = next.getNext();
		}
		return null;
	}
	
}
