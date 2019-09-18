package com.tanpham.playaround;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

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
    public void addNewItem() {
        myVector.add("Java");
        myVector.add("Python");
        assertThat(myVector.size(), equalTo(2));
        assertThat(myVector.get(0), equalTo("Java"));
        assertThat(myVector.get(1), equalTo("Python"));
    }
    
//    @Test
//    public void 
    
//    @Test
//    public void addNewItem_butItIsNotInSequenceOfNextIndex_expectIndexOutBoundException() {
//        myVector.add("Java");
//    }
    
//    @Test
//    public void myVector_setItemWithIndex() {
//        myVector.set(5, 100l);
//        assertThat(myVector.get)
//    }
    
}
