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
		
		// By accident, the "Switzerland" and "USA" have the same hashcode and it's in third position =))
		// This means we will have collision in third position, we have to make sure
		// the Washington does not override Bern
		assertThat(hashTable.get("Switzerland"), equalTo("Bern"));
		assertThat(hashTable.get("USA"), equalTo("Washington"));
	}
	
	@Test
	public void add_nullKey() {
		hashTable.add(null, "Hanoi");
		assertThat(hashTable.get(null), equalTo("Hanoi"));
	}
	
}
