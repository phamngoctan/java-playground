# java-playground
java-playground project to test all the concern about java core
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
 
Notes:  
 - support null key
 - in Java 8, to improve the performance of HashMap, put() method’s implementation has been updated to use a Red Black Tree if there are more than 8 Entries in the same bucket.
 - having more than one Entry in a bucket is called Hash Collision and the Linked list approach to contain Entries with same hash values in the same bucket is called chaining.

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
## Bit's complement
### Ones' complement
How to calculate the binary of a number into it's ones' complement  
It is the same like positive number, but use the first bit to mark the number is negative or not.  
 - If the first number is 1, it is negative.
 - If it is 0, it is positive. 

### Two's complement
How to calculate the binary of a number into it's twos' complement  
Reverse all its bits, then plus 1 to the result of the previous reverse step

### Bit utils
Add absolute function of an integer variable in bit approach, the performance could be better than Math.abs. But only use it when you really need to improve the performance of the system.

