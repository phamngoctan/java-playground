package com.tanpham.playaround.datastructure.hashing;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

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
	public void add_happyPath_newItem() {
		hashTable.add("vietnam", "Ha noi");
	}
	
	@Test
	public void hash_function() {
		assertThat(hashTable.hash("vietnam", 16), equalTo(8));
	}
	
}
