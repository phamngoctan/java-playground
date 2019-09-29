package com.tanpham.playaround.datastructure;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
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
    
    /**
     * Python -> Java
     */
    @Test
    public void popFront_whenThereAreMoreThanOneItemRemaining() {
    	linkedList.pushFront("Java");
    	linkedList.pushFront("Python");
    	
    	assertThat(linkedList.popFront(), equalTo("Python"));
    	assertThat(linkedList.valueAt(0), equalTo("Java"));
    	assertThat(linkedList.size(), equalTo(1));
    }
    
    @Test
    public void popFront_whenThereIsNoRemainingItem() {
    	linkedList.pushFront("Java");
    	
    	assertThat(linkedList.popFront(), equalTo("Java"));
    	assertThat(linkedList.size(), equalTo(0));
    }
    
    @Test
    public void getItemValueRightBeforeTail_inCaseSizeLessThan1_nullShouldBeReturned() {
    	assertThat(linkedList.pickValueRightBeforeTail(), equalTo(null));
    }
    
    @Test
    public void getItemValueRightBeforeTail_inCaseSizeEquals1_nullShouldBeReturned() {
    	linkedList.pushFront("Java");
    	assertThat(linkedList.pickValueRightBeforeTail(), equalTo(null));
    }
    
    /**
     * Python -> Java
     */
    @Test
    public void getItemValueRightBeforeTail_correctValueShouldBeReturned() {
    	linkedList.pushFront("Java");
    	linkedList.pushFront("Python");
    	
    	assertThat(linkedList.pickValueRightBeforeTail(), equalTo("Python"));
    }
    
    @Test
    public void popBack_whenThereIsNoRemainingItem() {
    	linkedList.pushFront("Java");
    	assertThat(linkedList.popBack(), equalTo("Java"));
    	assertThat(linkedList.size(), equalTo(0));
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void popFront_makeSureTheTailIsUpdated_inCaseTheSizeReduceToZero() {
    	linkedList.pushFront("Java");
    	linkedList.popFront();
    	assertThat(linkedList.size(), equalTo(0));
    	linkedList.popBack();
    }
    
    @Test
    public void pushBack_newItemAdded() {
    	linkedList.pushFront("Java");
    	linkedList.pushBack("Python");
    	assertThat(linkedList.size(), equalTo(2));
    	assertThat(linkedList.valueAt(1), equalTo("Python"));
    }
    
    @Test
    public void pushBack_makeSureTheHeadIsUpdatedWhenInitTheLinkedListFromTheTail() {
    	linkedList.pushBack("Java");
    	linkedList.pushFront("Python");
    	assertThat(linkedList.valueAt(1), equalTo("Java"));
    }
    
    @Test
    public void front_caseNoItemYet_shouldReturnNull() {
    	assertThat(linkedList.front(), nullValue());
    }
    
    @Test
    public void front_caseThereIsItemOnHead() {
    	linkedList.pushBack("Java");
    	assertThat(linkedList.front(), equalTo("Java"));
    }
    
    @Test
    public void back_caseNoItemYet_shouldReturnNull() {
    	assertThat(linkedList.back(), nullValue());
    }
    
    @Test
    public void back_caseThereIsItemOnHead() {
    	linkedList.pushFront("Java");
    	assertThat(linkedList.back(), equalTo("Java"));
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void insert_withNegativeIndex_exceptionShouldBeThrown() {
    	linkedList.insert(-1, "Java");
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void insert_withIndexBiggerThanSize_exceptionShouldBeThrown() {
    	linkedList.insert(1, "Java");
    }
    
    @Test
    public void insert_withIndexEqualSize_newItemShouldBeInsertedCorrectly() {
    	linkedList.insert(0, "Java");
    	assertThat(linkedList.size(), equalTo(1));
    	assertThat(linkedList.valueAt(0), equalTo("Java"));
    }
    
    @Test
    public void insert_normalCase() {
    	linkedList.pushFront("Java");
    	linkedList.pushFront("Python");
    	linkedList.insert(1, "Swift");
    }
    
}
