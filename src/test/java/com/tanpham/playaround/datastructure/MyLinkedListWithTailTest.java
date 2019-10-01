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
    public void popFront_whenThereOneItem() {
    	linkedList.pushFront("Java");
    	
    	assertThat(linkedList.popFront(), equalTo("Java"));
    	assertThat(linkedList.size(), equalTo(0));
    }
    
    @Test
    public void popFront_twoItemsInList() {
    	linkedList.pushFront("Java");
    	linkedList.pushFront("Python");
    	
    	linkedList.popFront();
    	assertThat(linkedList.size(), equalTo(1));
    	assertThat(linkedList.valueAt(0), equalTo("Java"));
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void popFront_whenThereIsNoRemainingItem() {
    	linkedList.popFront();
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
    public void popBack_makeSureTheTailIsUpdated_inCaseTheSizeReduceToZero() {
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
    
    /**
     * Python -> Java
     */
    @Test
    public void insert_inTheMiddleOfList_allTheTrailingElementsShouldBeShiftedToTheRight() {
    	linkedList.pushFront("Java");
    	linkedList.pushFront("Python");
    	
    	linkedList.insert(1, "Swift");
    	
    	assertThat(linkedList.size(), equalTo(3));
    	assertThat(linkedList.valueAt(0), equalTo("Python"));
    	assertThat(linkedList.valueAt(1), equalTo("Swift"));
    	assertThat(linkedList.valueAt(2), equalTo("Java"));
    }
    
    /**
     * Java -> Python -> Swift
     */
    @Test
    public void insert_atTheEndOfListHasManyItem() {
    	linkedList.pushFront("Java");
    	linkedList.pushBack("Python");
    	linkedList.pushBack("Swift");
    	
    	linkedList.insert(3, "Android");
    	
    	assertThat(linkedList.size(), equalTo(4));
    	assertThat(linkedList.valueAt(3), equalTo("Android"));
    }
    
    /**
     * Java -> Python -> Swift
     */
    @Test
    public void insert_atTheHeadOfListHasManyItem() {
    	linkedList.pushFront("Java");
    	linkedList.pushBack("Python");
    	linkedList.pushBack("Swift");
    	
    	linkedList.insert(0, "Android");
    	
    	assertThat(linkedList.size(), equalTo(4));
    	assertThat(linkedList.valueAt(0), equalTo("Android"));
    	assertThat(linkedList.valueAt(3), equalTo("Swift"));
    }
    
    @Test
    public void prepend_alsoShouldBeSupported() {
    	linkedList.insert(0, "Java");
    	linkedList.prepend("Python");
    	
    	assertThat(linkedList.size(), equalTo(2));
    	assertThat(linkedList.valueAt(0), equalTo("Python"));
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void delete_whenLinkedListEmpty_shouldThrowException() {
    	linkedList.delete(0);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void delete_withNegativeIndex_shouldThrowException() {
    	linkedList.delete(-1);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void delete_butTheIndexBiggerThanTheSize() {
    	linkedList.insert(0, "Java");
    	linkedList.delete(1);
    }
    
    @Test
    public void delete_whenThereIsOneItem_listShouldBeEmpty() {
    	linkedList.insert(0, "Java");
    	linkedList.delete(0);
    	
    	assertThat(linkedList.size(), equalTo(0));
    	assertThat(linkedList.empty(), equalTo(true));
    }
    
    @Test
    public void delete_whenThereAreManyItemInside() {
    	linkedList.insert(0, "Java");
    	linkedList.insert(1, "Python");
    	linkedList.insert(2, "Swift");
    	
    	linkedList.delete(1);
    	assertThat(linkedList.size(), equalTo(2));
    	assertThat(linkedList.valueAt(1), equalTo("Swift"));
    }
    
    @Test
    public void remove_butTheListIsEmpty_nothingHappened() {
        linkedList.remove("Java");
        
        assertThat(linkedList.size(), equalTo(0));
    }
    
    @Test
    public void remove_theItemToBeDeletedInTheMiddleOfList() {
    	linkedList.insert(0, "Python");
    	linkedList.insert(1, "Java");
    	linkedList.insert(2, "Swift");
    	
    	linkedList.remove("Java");
    	assertThat(linkedList.size(), equalTo(2));
    	assertThat(linkedList.valueAt(0), equalTo("Python"));
    	assertThat(linkedList.valueAt(1), equalTo("Swift"));
    }
    
    @Test
    public void remove_theItemToBeDeletedInTheEndOfList() {
    	linkedList.insert(0, "Python");
    	linkedList.insert(1, "Java");
    	linkedList.insert(2, "Swift");
    	
    	linkedList.remove("Swift");
    	assertThat(linkedList.size(), equalTo(2));
    	assertThat(linkedList.valueAt(0), equalTo("Python"));
    	assertThat(linkedList.valueAt(1), equalTo("Java"));
    }
    
    @Test
    public void remove_inCaseAtTheHeadIsTheItemNeedToBeDeleted() {
    	linkedList.insert(0, "Java");
    	
    	linkedList.remove("Java");
    	assertThat(linkedList.size(), equalTo(0));
    }
    
    @Test
    public void remove_inCaseAtTheHeadIsTheItemNeedToBeDeleted_allTheTrailingElementsShouldBeShiftedLeft() {
        linkedList.insert(0, "Java");
        linkedList.insert(1, "Python");

        linkedList.remove("Java");
        assertThat(linkedList.size(), equalTo(1));
        assertThat(linkedList.valueAt(0), equalTo("Python"));
    }
    
    @Test
    public void remove_makeSureTheTailIsCorrectlyShiftLeft() {
        linkedList.insert(0, "Java");
        linkedList.insert(1, "Python");
        linkedList.insert(2, "Swift");
        
        // This should make the tail point to Python
        linkedList.remove("Swift");
        
        // this action depend on the tail, so we can rely on to test the tail pointer
        linkedList.pushBack("Android");

        assertThat(linkedList.size(), equalTo(3));
        assertThat(linkedList.valueAt(2), equalTo("Android"));
    }
    
    @Test
    public void remove_multipleItemsAreRemovedInARow() {
        linkedList.insert(0, "Java");
        linkedList.insert(1, "Java");
        linkedList.insert(2, "Java");
        
        // This should make the tail point to Python
        linkedList.remove("Java");
        assertThat(linkedList.size(), equalTo(0));
    }
    
    @Test
    public void reverse_inCaseEmptyList() {
        linkedList.reverse();
        assertThat(linkedList.size(), equalTo(0));
    }
    
    @Test
    public void reverse_inCaseOneItem() {
        linkedList.prepend("Java");
        
        linkedList.reverse();
        assertThat(linkedList.size(), equalTo(1));
        assertThat(linkedList.valueAt(0), equalTo("Java"));
    }
    
    @Test
    public void reverse_inCaseTwoItems() {
        linkedList.insert(0, "Java");
        linkedList.insert(1, "Python");
        
        linkedList.reverse();
        assertThat(linkedList.valueAt(0), equalTo("Python"));
        assertThat(linkedList.valueAt(1), equalTo("Java"));
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void erase_inCaseEmptyList() {
    	linkedList.erase(0);
    }
    
    @Test
    public void erase_atTheHead() {
    	linkedList.pushFront("Java");
    	linkedList.erase(0);
    	
    	assertThat(linkedList.size(), equalTo(0));
    }
    
    @Test
    public void erase_atTheTail() {
    	linkedList.pushFront("Python");
    	linkedList.pushFront("Java");
    	linkedList.erase(1);
    	
    	assertThat(linkedList.size(), equalTo(1));
    	assertThat(linkedList.valueAt(0), equalTo("Java"));
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void valueOfIndexCountFromEnd_emptyList() {
    	linkedList.valueOfIndexCountFromEnd(0);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void valueOfIndexCountFromEnd_indexOutOfUpperBound() {
    	linkedList.valueOfIndexCountFromEnd(5);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void valueOfIndexCountFromEnd_indexOutOfLowerBound() {
    	linkedList.valueOfIndexCountFromEnd(-1);
    }
    
    @Test
    public void valueOfIndexCountFromEnd_rightAtTheTail() {
    	linkedList.pushFront("Java");
    	assertThat(linkedList.valueOfIndexCountFromEnd(0), equalTo("Java"));
    }
    
    @Test
    public void valueOfIndexCountFromEnd_manyItems() {
    	linkedList.pushFront("Java");
    	linkedList.pushBack("Python");
    	assertThat(linkedList.valueOfIndexCountFromEnd(0), equalTo("Python"));
    }
    
}
