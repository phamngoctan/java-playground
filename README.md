# java-playground
java-playground project to test, to play round all the concerns about:
 - java core
 - data structures
 - algorithms

*Because this repository just reflects the view of author, please feedback me via email phamngoctan.com@gmail.com if you have any concerns*.

# how to run
mvn clean test

# Data structures
## Vector
## LinkedList
Reverse a linkedlist using two pointers approach
 - reverse
 - size
 - empty
 - valueAt
 - pushFront
 - popFront
 - popBack
 - pickValueRightBeforeTail
 - pushBack
 - front
 - back
 - insert
 - prepend
 - remove
 - findMiddle
 - delete at position
 - detectCircularDependency using two pointers, one pointer run at 1 node speed, another point run at 2 nodes speed. if the second pointer reach the first one, this linkedlist is circular dependency

## Queue
## Stack
## HashTable
This implementation follows this tutorial https://dzone.com/articles/custom-hashmap-implementation-in-java  
It includes:
 - hash(k, m) - m is size of hash table
 - add(key, value) - if key already exists, update value
 - exists(key)
 - get(key)
 - remove(key)
 - capacity() //testing purpose
 - size() //testing purpose
 
Notes:  
 - support null key
 - in Java 8, to improve the performance of HashMap, put() method’s implementation has been updated to use a Red Black Tree if there are more than 8 Entries in the same bucket.
 - having more than one Entry in a bucket is called Hash Collision and the Linked list approach to contain Entries with same hash values in the same bucket is called chaining.
 - consider implementing the capacity as a prime number, this can prevent the collision better (https://web.archive.org/web/19990903133921/http://www.concentric.net/~Ttwang/tech/primehash.htm).
 - why the remove method checks if the size = current_capacity / 4 to do the re-index? Because it would prevent the situation that someone adds one more item at the increasing_point. Then, he/she again deletes item at the decreasing_point. This would make the add/remove O(n) always. At least, divide for 4 would prevent that.

## Binary tree
Implement core binary trees
 - getTreeByLevelOrderTravelling // get the tree by level order traversal so called breadth-first search
 - getTreeByInOrder // one in three deep-first search approaches, left/self/right
 - getTreeByPreOrder // self/left/right
 - getTreeByPostOrder // left/right/self

For the PreOrder (Root Left Right) traversal without using recursive approach, the implementation idea can be:
 - First add the root to the Stack.
 - Pop out an element from Stack and add its right and left children to stack. (Root is printed)
 - Pop out an element and print it and add its children.
 - Repeat the above two steps until the Stack empty.

For the InOrder (Left Root Right) traversal without using recursive approach, the implementation idea can be:
 - pre-process: travel to the most far left child, on the way, add all the nodes to the stack
 - while stack is not empty: 
   
    - pop out the item and print it. if it has right item, push it to the stack.

For the PostOrder (Left Right Root) traversal without using recursive approach, the implementation idea can be:
 - the idea is like the other one, one important point is that there is the marker for checking if the current node is checked. Next time go back to it, no need to check the right child anymore, otherwise, it will cause the infinitive loop.

## Binary search tree
Idea of deleting a Node, we separates it into three cases:
 - the deleting node is a leave, keep the previous node and just set its pointer to null
 - the deleting node is root but it has only a child. Get its child and use the previous node point to its child. Done.
 - the deleting node is root with two children. Find the smallest right child Node data, put it to the deleting node data. Finally, remove the smallest right node.
 - get height of the tree
 - getValue of tree from min to max order
 - isInTree for checking a value is in the tree or not
 - getNodeCount for counting how many time a value matches inside the binary search tree
 - getMin
 - getMax
 - getSuccessor //returns next-highest value in tree after given value, -1 if none. If the matched node has the right node, find smallest node of that right child. If the matched node has the left child only, we have to loop from the root to the matched node again. If the checking node has child which makes the matchedNode on the its left side, make it as ancestor. Do it until reach the matched node. Check the implementation and test cases for more details.
 
## Heap
An array visualized as a nearly complete binary tree (MIT course)
Heap properties:
 - Every node has a value at least as large as the values in that node's children.
 - Index from 1: i left = 2i; i right = 2i + 1; i parent = i/2
 - Index from 0: i left = 2i + 1; i right = 2i + 2; i parent = (i - 1)/2
 
Heapify assume that - **Given a node at index i whose left and right subtrees are max-heaps** - MAX-HEAPIFY moves the node at i down the max-heap until it no longer violates the max-heap property (that is, the node is not smaller than its children).

Issues when implementing a heap:
 - How to maintain the sorted heap when modifying the heap
 - How do we build the max-heap out of unsorted initial array

Implementation:
 - insert
 - getMax - returns the max item, without removing it
 - size() - return number of elements stored
 - isEmpty() - returns true if heap contains no elements
 - extractMax - returns the max item, removing it
 - remove(i) - removes item at index x
 - heapify - create a heap from an array of elements, needed for heap_sort
 - heap_sort() - take an unsorted array and turn it into a sorted array in-place using a max heap
    - note: using a min heap instead would save operations, but double the space needed (cannot do in-place).

## Sorting
Stability in sorting algorithms.
Which algorithms can be used on linked lists? Which on arrays? Which on both?

### Bubble sort
This implementation is just for playing around with sorting algorithms. Bubble's terrible - O(n^2), except when n <= 16.

### Merge sort
Applying on LinkedList. I wouldn't recommend sorting a linked list, but merge sort is doable.
Applying on an Array. The idea is that we have to maintain the index correctly each time we split the array.
For merge sort, we have the possibility to sort without using recursive. By using level, each time we increase one level. 

The idea to implement it is that:
 - split into two parts
 - call recursively the proceed for first part & second part
 - merge the two sorted parts & return the sorted one

One of the most important method is the merge two sorted arrays, the recursive calls to the splitted arrays will make it finally reach to the smallest unit of an item. One single item would be a sorted array, so from that moment, the mergeTwoSortedArrays will do its job.

Complexity: n log n

Performance consideration:
 - in Python, 2.2 n log n (microsecond)
### Heap sort
One of the nice properties of HeapSort is that it is an in-place algorithm. It only needs a fixed amount of memory beyond what is used to store the data being sorted.
### Selection sort
### Insertion sort
For the sake of implementing sorting idea, it does not support generic approach. Basically, it maintains two partitions, first part is always sorted. So we will check the second part and move the unsorted item from it to the sorted one of the first part.

Complexity: n square.

Performance consideration:
 - in Python, 0.2 n square (microsecond)
 - in C, 0.01 n square (microsecond)
### Binary Insertion sort - improved from Insertion sort
Check & swap can be replaced with binary search and swap, because the first part is already sorted. 
So we can perform binary search on the part. 
And it is resulted in a better result. 
n log n. But even we can find the correct position, we also have to shift the array. So the swap still be needed. 

### Quick sort
The idea to implement it is that: for every j (partition point), every item in the left should be smaller than the arr[j], every item in the right should be bigger than the arr[j]. The most important method should be the partition(...) method.

This repo has two implementations of QuickSort:
 - One without supporting duplicate keys handling
 - One with supporting duplicate keys handling

#Algorithms
## Array exercises
Notes: There are several ways to loop through two arrays (i, j):
 - i, j = 0: we can loop through i using for, every i, use while to increase j. Every time i is changed, we maintain an smaller array (Day2Books). Time complexity will be O(2n) --> O(n)
 - i, j = 0: we can use while (i < iLength && j < jLenght), we increase (i or j) or increase both of them (Day2Dress'em In Vests). Time complexity will be O(n*m)

# Multi-threads
Create one sidecar thread to proceed the data, one main thread to hold the result, one client to get the real-processed data, support the timeout also

## Sleep
## Join
## Wait
## Yield
## Thread deadlock
Don't run it on any online IDE.  
Just run it on our local machine.  
To trace the deadlock, we can use JMC (java mission control) or JVisualVM in bin folder of our JDK installation. 

## Exception handling in the java.util.concurrent.Executor
### FixedThreadPoolCheck
Check without shutdown() explicitly, the threadpool still there, this could lead to the situation that we run out of maximum thread pool allowed

# Miscellaneous
## Binary search
Add implementation for binary search using:
 - recursive approach
 - while loop approach

## Bit's complement
### Ones' complement
How to calculate the binary of a number into it's ones' complement  
It is the same like positive number, but use the first bit to mark the number is negative or not.  
 - If the first number is 1, it is negative.
 - If it is 0, it is positive. 
Declaring a byte in java, two ways:
 - byte x = 0b10 --> 2, 0b1000 --> 8, -0b10 --> -2
 - byte x = 8 --> equivalent to 0b1000

### Two's complement
How to calculate the binary of a number into it's twos' complement  
Reverse all its bits, then plus 1 to the result of the previous reverse step

### Bit utils
 - Add absolute function of an integer variable in bit approach, the performance could be better than Math.abs. But only use it when you really need to improve the performance of the system.
 - Add fetch bit at a position from an integer
 - Check if a given number is a power of 2
 - Find missing pair item of a given array
 - Find the number of set bits in a binary representation of a number
 - Swap two integers
 - Kernighan's Bit Counting (**really cool idea**)
 
## .PEM extension file
Storing .pem file in database, to test it:
 - create postgres database, set up the database connection "jdbc:postgresql://localhost:5454/test"
 - execute the src/main/resources/sql/cryptography.sql in public schema of test database
 - run main method in Cryptography class
 - To check the result, you can go to the database to check the encrypted content in new inserted row. Or maybe you can check the console log
 
## Reference
 - https://github.com/jwasham/coding-interview-university
 - https://www.youtube.com/watch?v=Hzuzo9NJrlc&feature=youtu.be - counting bit sets
 - https://bits.stephan-brumme.com/absInteger.html
 - https://github.com/jeffemandel/storecert
 - https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm
 - https://www.coursera.org/learn/algorithms-part1/lecture/vjvnC/quicksort
 - https://www.geeksforgeeks.org/thread-pools-java/
 - https://stackify.com/java-thread-pools/#wpautbox_about
