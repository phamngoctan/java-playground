package com.tanpham.playaround.datastructure.hashing;

import java.util.Arrays;

public class MyHashTable<K, V> {
	
	// this default capacity can increase the possibilities of collision
	// consider to change to a prime number
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
			int newCapacity = capacity * 2;
			increaseHashTableCapacity(newCapacity);
			capacity = newCapacity;
		}
		
		int processedHashCode = getProcessedHashCode(key);
		Entry<K, V> entry = new Entry<>(key, value);
		entry.setHash(processedHashCode);
		int index = indexFor(processedHashCode, capacity);
		
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
	
	@SuppressWarnings("unchecked")
	private void increaseHashTableCapacity(int newCapacity) {
		Entry<K, V>[] newBuckets = new Entry[newCapacity];
		for (int i = 0; i < capacity; i++) {
			if (buckets[i] != null) {
				Entry<K, V> next = buckets[i];
				while (next != null) {
					newBuckets[indexFor(next.getHash(), newCapacity)] = next;
					next = next.getNext();
				}
			}
		}
		buckets = newBuckets;
	}

	private void throwExceptionIfValueIsNull(V value) {
		if (value == null) {
			throw new RuntimeException("Hash table does not allow null value");
		}
	}

	public int indexFor(int processedHashCoe, int capacity) {
		// More effective than the modulus %
		// hash value H the index generated with the bitwise formula �H AND 16� 
		// is going to be either capacity minus 1 or 0
		return processedHashCoe & (capacity - 1);
	}

	private int getProcessedHashCode(K key) {
		int maximumNumberOfSignedInteger = 0x7fffffff;
		int hashCode = key == null ? 0 : key.hashCode();
		int maskOutTheSignedBitFromAnyValueToZero = hashCode & maximumNumberOfSignedInteger;
		return maskOutTheSignedBitFromAnyValueToZero;
	}

	public V get(K key) {
		int index = indexFor(getProcessedHashCode(key), capacity);
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
