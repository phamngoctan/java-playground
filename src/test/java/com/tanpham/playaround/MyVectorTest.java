package com.tanpham.playaround;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MyVectorTest {
    
    private MyVector<String> myVector;
    
    @Before
    public void init() {
        myVector = new MyVector<String>();
    }

    @Test
    public void myVector_initialSizeShouldBe_10() {
        assertThat(myVector.capacity(), equalTo(10));
    }
    
    @Test
    public void whenGetItemWithIndex() {
        assertThat(myVector.get(1), equalTo(null));
    }
    
    @Test
    public void getSizeOfVector_whenNoItemInside() {
        assertThat(myVector.size(), equalTo(0));
    }
    
    @Test
    public void push_NewItem_shouldReturnTrue() {
        assertThat(myVector.push("Java"), equalTo(true));
    }
    
    @Test
    public void push_NewItem() {
        myVector.push("Java");
        myVector.push("Python");
        assertThat(myVector.size(), equalTo(2));
        assertThat(myVector.get(0), equalTo("Java"));
        assertThat(myVector.get(1), equalTo("Python"));
    }
    
    @Test
    public void push_capacityIncrease_1Point5Time() {
    	for (int i = 0; i < 10; i++) {
            myVector.push("Item " + i);
        }
    	myVector.push("Item " + 11);
        assertThat(myVector.size(), equalTo(11));
        assertThat(myVector.capacity(), equalTo(15));
    }
    
    @Test
    public void insert_newItem_toSpecificIndex() {
        myVector.insert(0, "Java");
        assertThat(myVector.size(), equalTo(1));
        assertThat(myVector.get(0), equalTo("Java"));
    }
    
    @Test
    public void insert_toExistedItem_sizeShouldNotIncrease() {
        myVector.push("Java");
        myVector.insert(0, "Java 8");
        assertThat(myVector.size(), equalTo(1));
    }
    
    // Invalid test
    @Ignore
    @Test
    public void insert_toExistedItem_shouldReplaceTheOldOne() {
        myVector.push("Java");
        myVector.insert(0, "Java 8");
        assertThat(myVector.get(0), equalTo("Java 8"));
    }
    
    @Test
    public void insert_toExistedItem_shouldShiftAllTrailingElementsToTheRight() {
        myVector.push("Java");
        myVector.insert(0, "Java 8");
        assertThat(myVector.size(), equalTo(2));
        assertThat(myVector.get(0), equalTo("Java 8"));
        assertThat(myVector.get(1), equalTo("Java"));
    }
    
    @Test(expected = java.lang.ArrayIndexOutOfBoundsException.class)
    public void insert_negativeIndex_exceptionShouldBeThrown() {
        myVector.insert(-1, "Python");
    }
    
    @Test(expected = java.lang.ArrayIndexOutOfBoundsException.class)
    public void insert_newItem_butItIsNotInSequenceOfNextIndex_expectIndexOutBoundException() {
        myVector.push("Java");
        myVector.insert(2, "Swift");
    }
    
    @Test
    public void insert_butNextItemIsOverTheCapacity() {
        for (int i = 0; i < 10; i++) {
            myVector.push("Item " + i);
        }
        assertTrue(myVector.insert(10, "Item 10"));
    }
    
    @Test
    public void isEmpty() {
    	assertThat(myVector.isEmpty(), equalTo(true));
    }
    
    @Test
    public void at() {
    	myVector.push("Java");
    	assertThat(myVector.at(0), equalTo("Java"));
    }
    
}
