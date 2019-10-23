package com.tanpham.playaround.datastructure.hashing;

import org.junit.Before;
import org.junit.Test;

import com.tanpham.playaround.datastructure.hashing.MyHashTable;

public class MyHashTableTest {
	
	private MyHashTable<String, String> hashTable;
	
	@Before
	public void init() {
		hashTable = new MyHashTable<>();
	}

	@Test
	public void put_happyPath_putNewItem() {
		hashTable.put("vietnam", "Ha noi");
	}
	
}
