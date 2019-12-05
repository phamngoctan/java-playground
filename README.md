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
 - sift_up - needed for insert
 - get_max - returns the max item, without removing it
 - get_size() - return number of elements stored
 - is_empty() - returns true if heap contains no elements
 - extract_max - returns the max item, removing it
 - sift_down - needed for extract_max
 - remove(i) - removes item at index x
 - heapify - create a heap from an array of elements, needed for heap_sort
 - heap_sort() - take an unsorted array and turn it into a sorted array in-place using a max heap
    - note: using a min heap instead would save operations, but double the space needed (cannot do in-place).

### Heap sort
One of the nice properties of HeapSort is that it is an in-place algorithm. It only needs a fixed amount of memory beyond what is used to store the data being sorted.

# Multi-threads
## Sleep
## Join
## Wait
## Yield
## Thread deadlock
Don't run it on any online IDE.  
Just run it on our local machine.  
To trace the deadlock, we can use JMC (java mission control) or JVisualVM in bin folder of our JDK installation. 

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

