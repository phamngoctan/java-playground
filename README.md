# java-playground
java-playground project to test, to play round all the concerns about:
 - java core
 - data structures
 - algorithms

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

## Binary search tree

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

