package com.tanpham.playaround;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

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
    	makeMyVectorIncreaseTheCapacity();
    	myVector.push("Item " + 11);
        assertThat(myVector.size(), equalTo(11));
        assertThat(myVector.capacity(), equalTo(20));
    }
    
    @Test
    public void insert_newItem_toSpecificIndex() {
        myVector.insert(0, "Java");
        assertThat(myVector.size(), equalTo(1));
        assertThat(myVector.get(0), equalTo("Java"));
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
        makeMyVectorIncreaseTheCapacity();
        assertThat(myVector.size(), equalTo(11));
        assertThat(myVector.capacity(), equalTo(20));
    }

    private void makeMyVectorIncreaseTheCapacity() {
        for (int i = 0; i < 10; i++) {
            myVector.push("Item " + i);
        }
        myVector.insert(10, "Item 10");
    }
    
    @Test
    public void isEmpty() {
    	assertThat(myVector.isEmpty(), equalTo(true));
    }
    
    @Test
    public void isEmpty_notEmptyCase() {
        myVector.push("Java");
        assertThat(myVector.isEmpty(), equalTo(false));
    }
    
    @Test
    public void at() {
    	myVector.push("Java");
    	assertThat(myVector.at(0), equalTo("Java"));
    }
    
    @Test
    public void prepend_zeroIndexInsertion() {
        myVector.push("Java");
        myVector.prepend("Java 11");
        assertThat(myVector.size(), equalTo(2));
        assertThat(myVector.at(0), equalTo("Java 11"));
        assertThat(myVector.at(1), equalTo("Java"));
    }
    
    @Test
    public void pop_getTheVeryTopReturned_removeTheRefToIt() {
        myVector.push("Java");
        myVector.push("Python");
        myVector.push("DotNet");
        String result = myVector.pop();
        assertThat(result, equalTo("DotNet"));
        assertThat(myVector.size(), equalTo(2));
    }
    
    @Test
    public void pop_expectTheDecreasingSizeBehaviorTrigger() {
        makeMyVectorIncreaseTheCapacity();
        assertThat(myVector.capacity(), equalTo(20));
        myVector.pop();
        assertThat(myVector.capacity(), equalTo(10));
    }
}
