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
		hashTable.add("Vietnam", "Hanoi");
		hashTable.add("Australia", "Melbourne");
		hashTable.add("Switzerland", "Bern");
		hashTable.add("USA", "Washington");
	}
	
	@Test
	public void hash_function() {
		assertThat(hashTable.hash("vietnam", 4), equalTo(0));
	}
	
}
