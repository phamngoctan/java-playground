package com.tanpham.playaround;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MyVectorTest {
    
    private MyVector<String> myVector;
    
    @Before
    public void init() {
        myVector = new MyVector<String>();
    }

    @Test
    public void myVector_initialSizeShouldBe_10() {
        assertThat(myVector.getCapacity(), equalTo(10));
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
    public void addNewItem_shouldReturnTrue() {
        assertThat(myVector.add("Java"), equalTo(true));
    }
    
    @Test
    public void addNewItem() {
        myVector.add("Java");
        myVector.add("Python");
        assertThat(myVector.size(), equalTo(2));
        assertThat(myVector.get(0), equalTo("Java"));
        assertThat(myVector.get(1), equalTo("Python"));
    }
    
    @Test
    public void add_newItem_toSpecificIndex() {
        myVector.add(0, "Java");
        assertThat(myVector.size(), equalTo(1));
        assertThat(myVector.get(0), equalTo("Java"));
    }
    
    @Test
    public void add_toExistedItem_sizeShouldNotIncrease() {
        myVector.add("Java");
        myVector.add(0, "Java 8");
        assertThat(myVector.size(), equalTo(1));
    }
    
    @Test
    public void add_toExistedItem_shouldReplaceTheOldOne() {
        myVector.add("Java");
        myVector.add(0, "Java 8");
        assertThat(myVector.get(0), equalTo("Java 8"));
    }
    
    @Test(expected = java.lang.ArrayIndexOutOfBoundsException.class)
    public void add_negativeIndex_exceptionShouldBeThrown() {
        myVector.add(-1, "Python");
    }
    
    @Test(expected = java.lang.ArrayIndexOutOfBoundsException.class)
    public void addNewItem_butItIsNotInSequenceOfNextIndex_expectIndexOutBoundException() {
        myVector.add("Java");
        myVector.add(2, "Swift");
    }
    
    @Test
    public void add_butNextItemIsOverTheCapacity() {
        for (int i = 0; i < 10; i++) {
            myVector.add("Item " + i);
        }
        assertTrue(myVector.add(10, "Item 10"));
    }
    
    @Test
    public void add_capacityIncrease_1Point5Time() {
        
    }
    
}
