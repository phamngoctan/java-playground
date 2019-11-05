package com.tanpham.playaround.datastructure.hashing;

public class Entry<K, V> {
	private final K key;
	private V value;
	private Entry<K, V> next;
	private int hash;

	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public int getHash() {
		return hash;
	}

	public void setHash(int hash) {
		this.hash = hash;
	}

	public Entry<K, V> getNext() {
		return next;
	}

	public void setNext(Entry<K, V> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Entry [key=" + key + ", value=" + value + "]";
	}
	
}
