package com.tanpham.playaround.datastructure.hashing;

import java.util.Arrays;

public class MyHashTable<K, V> {
	
	private int capacity = 16;
	private int size = 0;
	private Entry<K, V>[] buckets;
	
	@SuppressWarnings("unchecked")
	public MyHashTable() {
		buckets = new Entry[capacity];
	}

	@Override
	public String toString() {
		return "MyHashTable [buckets=" + Arrays.toString(buckets) + "]";
	}

	public V add(K key, V value) {
		throwExceptionIfValueIsNull(value);
		if (size == capacity - 1) {
			increaseHashTableCapacity(capacity * 2);
		}
		
		Entry<K, V> entry = new Entry<>(key, value);
		int index = indexFor(key, capacity);
		
		Entry<K, V> next = buckets[index];
		boolean isKeyExisted = false;
		V previousValue = null;
		while (next != null && isKeyExisted == false) {
			if (key == next.getKey() || key.equals(next.getKey())) {
				previousValue = next.getValue();
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
		if (!isKeyExisted) {
			return null;
		} else {
			return previousValue;
		}
	}
	
	private void increaseHashTableCapacity(int newCapacity) {
		
	}

	private void throwExceptionIfValueIsNull(V value) {
		if (value == null) {
			throw new RuntimeException("Hash table does not allow null value");
		}
	}

	public int indexFor(K key, int capacity) {
		int maximumNumberOfSignedInteger = 0x7fffffff;
		int hashCode = key == null ? 0 : key.hashCode();
		int maskOutTheSignedBitFromAnyValueToZero = hashCode & maximumNumberOfSignedInteger;
		// More effective than the modulus %
		// hash value H the index generated with the bitwise formula “H AND 16” 
		// is going to be either capacity minus 1 or 0
		return maskOutTheSignedBitFromAnyValueToZero & (capacity - 1);
	}

	public V get(K key) {
		int index = indexFor(key, capacity);
		Entry<K, V> next = buckets[index];
		while (next != null) {
			if (key == next.getKey() || key.equals(next.getKey())) {
				return next.getValue();
			}
			next = next.getNext();
		}
		return null;
	}

	//Exposing two methods for testing purpose
	public int capacity() {
		return capacity;
	}

	public int size() {
		return size;
	}
	
}
