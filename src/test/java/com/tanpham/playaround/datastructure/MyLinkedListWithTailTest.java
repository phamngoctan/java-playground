package com.tanpham.playaround.datastructure;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MyLinkedListWithTailTest {

    private MyLinkedListWithTail<String> linkedList;
    
    @Before
    public void init() {
        linkedList = new MyLinkedListWithTail<>();
    }
    
    @Test
    public void size_emptyLinkedList_shouldHaveSizeZero() {
        assertThat(linkedList.size(), equalTo(0));
    }
    
    @Test
    public void empty_checkIfLinkedListIsEmpty() {
        assertThat(linkedList.empty(), equalTo(true));
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void valueAt_noItemInLinkedListYet_shouldBeAnException() {
        linkedList.valueAt(0);
    }
    
    @Test
    public void pushFront_addItemToCompletelyNewLinkedList_sizeShouldBeOne() {
        linkedList.pushFront("Java");
        assertThat(linkedList.size(), equalTo(1));
        assertThat(linkedList.valueAt(0), equalTo("Java"));
    }
    
    @Test
    public void pushFront_addItemToCompletelyNewLinkedList_itShouldBeNotEmpty() {
        linkedList.pushFront("Java");
        assertThat(linkedList.empty(), equalTo(false));
    }
    
    @Test
    public void pushFront_addItemToCompletelyNewLinkedList_valueAtZeroIndexShouldHaveValue() {
        linkedList.pushFront("Java");
        assertThat(linkedList.valueAt(0), equalTo("Java"));
    }
    
    @Test
    public void valueAt_addTwoItems_findTheSecondOne() {
        linkedList.pushFront("Python");
        linkedList.pushFront("Java");
        assertThat(linkedList.size(), equalTo(2));
        assertThat(linkedList.valueAt(1), equalTo("Python"));
    }
    
}
