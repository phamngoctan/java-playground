package com.tanpham.playaround.datastructure.hashing;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
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
		String value = hashTable.add("USA", "Washington");
		
		// By accident, the "Switzerland" and "USA" have the same hashcode and it's in third position =))
		// This means we will have collision in third position, we have to make sure
		// the Washington does not override Bern
		assertThat(value, nullValue());
		assertThat(hashTable.get("Switzerland"), equalTo("Bern"));
		assertThat(hashTable.get("USA"), equalTo("Washington"));
	}
	
	@Test
	public void get_notExistedKey() {
		assertThat(hashTable.get("Vietnam"), equalTo(null));
	}
	
	@Test
	public void add_nullKey() {
		hashTable.add(null, "Hanoi");
		assertThat(hashTable.get(null), equalTo("Hanoi"));
	}
	
	@Test
	public void add_nullKeyTwice() {
		hashTable.add(null, "Jakarta");
		String valueReturnedOfAddingSecondTime = hashTable.add(null, "Hanoi");
		assertThat(valueReturnedOfAddingSecondTime, equalTo("Jakarta"));
		assertThat(hashTable.get(null), equalTo("Hanoi"));
	}
	
	@Test(expected = RuntimeException.class)
	public void add_nullValue() {
		hashTable.add("Vietnam", null);
	}
	
	@Test
	public void add_entriesDoesNotReachDefaultCapacity() {
		for (int i = 0; i < 12; i++) {
			hashTable.add(i + "", "value " + i);
		}
		assertThat(hashTable.size(), equalTo(12));
		assertThat(hashTable.capacity(), equalTo(16));
	}
	
	@Test
	public void add_entriesUntilReachingDefaultCapacity() {
		for (int i = 0; i < 16; i++) {
			hashTable.add(i + "", "value " + i);
		}
		assertThat(hashTable.size(), equalTo(16));
		assertThat(hashTable.capacity(), equalTo(32));
	}
	
	@Test
	public void remove_happyPath() {
		hashTable.add("Vietnam", "Hanoi");
		hashTable.remove("Vietnam");
		assertThat(hashTable.get("Vietnam"), equalTo(null));
	}
	
	// By accident, the "Switzerland" and "USA" have the same hashcode and it's in third position
	@Test
	public void remove_incaseThereIsACollision() {
		hashTable.add("Switzerland", "Bern");
		hashTable.add("USA", "Washington");
		hashTable.remove("USA");
		assertThat(hashTable.get("USA"), equalTo(null));
		assertThat(hashTable.get("Switzerland"), equalTo("Bern"));
	}
	
	@Test
	public void remove_nullKey() {
		hashTable.add(null, "Hanoi");
		hashTable.remove(null);
		assertThat(hashTable.get(null), equalTo(null));
	}
	
	@Test
	public void remove_nullKey_withCollisionAtIndexZero() {
		hashTable.add("0", "AnyCapital");
		hashTable.add(null, "Hanoi");
		hashTable.remove(null);
		assertThat(hashTable.get(null), equalTo(null));
		assertThat(hashTable.get("0"), equalTo("AnyCapital"));
	}
}
