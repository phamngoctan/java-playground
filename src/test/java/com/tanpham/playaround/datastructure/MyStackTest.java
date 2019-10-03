package com.tanpham.playaround.datastructure;

import static org.junit.Assert.assertThat;

import org.junit.Before;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

public class MyStackTest {
	private MyStack<String> myStack;

	@Before
	public void init() {
		myStack = new MyStack<>();
	}

	@Test
	public void empty_inCaseEmptyStack() {
		assertThat(myStack.empty(), equalTo(true));
	}
	
	@Test
	public void peek_inCaseEmptyStack() {
		assertThat(myStack.peek(), equalTo(null));
	}
	
	@Test
	public void pop_inCaseEmptyStack() {
		assertThat(myStack.pop(), equalTo(null));
	}

	@Test
	public void push_inCaseEmptyStack() {
		myStack.push("Java");
		assertThat(myStack.peek(), equalTo("Java"));
	}
	
	@Test
	public void search_inCaseEmptyStack() {
		assertThat(myStack.search("Java"), equalTo(-1));
	}
}
