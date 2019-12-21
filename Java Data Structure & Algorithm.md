# Abstract

# Data structures

## Sorting

### Inverse sort

**list**

```java
Collections.sort(list, Collections.reverseOrder());
```

**array**

```java
Arrays.sort(array, Collections.reverseOrder());
```

`Collections.reverseOrder()` returns a comparator for reverser sort.

## Auto-Unboxing and Cache

## Digit and Letter

`Character.isDigit(string.charAt(index))` ([JavaDoc](https://docs.oracle.com/javase/10/docs/api/java/lang/Character.html#isDigit(char))) will return true if it's a digit
`Character.isLetter(string.charAt(index))` ([JavaDoc](https://docs.oracle.com/javase/10/docs/api/java/lang/Character.html#isLetter(char))) will return true if it's a letter

### Conversion between char and int

```java
char five = '5; 
int x = five - '0';
// x = 5
```


=======
```java
public class Scratch
{
   public static void main(String[] args)
    {
        Integer a = 1000, b = 1000;  //1
        System.out.println(a == b);

        Integer c = 100, d = 100;  //2
        System.out.println(c == d);
   }
}
```

**Output:**

```java
false
true
```

Yep the first output is produced for comparing reference; 'a' and 'b' - these are two different reference. In point 1, actually two references are created which is similar as -

```java
Integer a = new Integer(1000);
Integer b = new Integer(1000);
```

The second output is produced because the `JVM` tries to save memory, when the `Integer` falls in a range (from -128 to 127). At point 2 no new reference of type Integer is created for 'd'. Instead of creating a new object for the Integer type reference variable 'd', it only assigned with previously created object referenced by 'c'. All of these are done by `JVM`.

These memory saving rules are not only for Integer. for memory saving purpose, two instances of the following wrapper objects (while created through boxing), will always be == where their primitive values are the same -

- Boolean
- Byte
- Character from **\u0000** to `\u007f` (7f is 127 in decimal)
- Short and Integer from **-128** to **127**
>>>>>>> 6fa49a1f945d078bf61ffc3ec14259c0ff96759f

## If Else Condition

```java
int a_val = a==null ? 0 : a.val;
int b_val = b==null ? 0 : b.val;
```

## Array

```java
int[][] visited = new int[rows][cols];
for(int[] a:visited){
    for (int b : a){
        System.out.print(b);
    }
    System.out.println("");
}
```

output:

```
00000
00000
00000
00000
```



## HashMap

Initialize HashMap with default values;

```java
// Initialize with no key&value
private Map<Integer, Integer> map1 = new HashMap<>();

// Initialize with default key&value
private Map<Integer, Integer> map2 = new HashMap<Integer, Integer>(){
        {
            put(0,1);
            put(1,1);
        }
    };
```

## ArrayDeque

https://www.geeksforgeeks.org/arraydeque-in-java/

ArrayDeque in Java provides a way to apply **resizable-array** in addition to the implementation of the Deque interface. It is also known as **Array Double Ended Queue** or Array Deck. This is a special kind of array that grows and allows users to add or remove an element from both the sides of the queue. Few important features of ArrayDeque are as follows:

- Array deques have **no capacity restrictions** and they grow as necessary to support usage.
- They are **not thread-safe** which means that in the absence of external synchronization, ArrayDeque does not support concurrent access by multiple threads.
- **Null elements are prohibited in the ArrayDeque.**
- ArrayDeque class is likely to be faster than Stack when used as a stack.
- ArrayDeque class is likely to be faster than LinkedList when used as a queue.

**Methods in ArrayDeque:**

1. [add(Element e) :](https://www.geeksforgeeks.org/arraydeque-add-method-in-java/) The method inserts particular element at the end of the deque.
2. [addFirst(Element e) :](https://www.geeksforgeeks.org/arraydeque-addfirst-method-in-java/) The method inserts particular element at the start of the deque.
3. [addLast(Element e) :](https://www.geeksforgeeks.org/arraydeque-addlast-method-in-java/) The method inserts particular element at the end of the deque. It is similiar to add() method
4. [clear() :](https://www.geeksforgeeks.org/arraydeque-clear-method-in-java/) The method removes all deque elements.
5. [size() :](https://www.geeksforgeeks.org/arraydeque-size-method-in-java/) The method returns the no. of elements in deque.
6. [clone() :](https://www.geeksforgeeks.org/arraydeque-clone-method-in-java/) The method copies the deque.
7. [contains(Obj) :](https://www.geeksforgeeks.org/arraydeque-contains-method-in-java/) The method checks whether a deque contains the element or not
8. [Iterator() :](https://www.geeksforgeeks.org/arraydeque-iterator-method-in-java/) The method returns an iterator over the deque.
9. [descendingIterator() :](https://www.geeksforgeeks.org/arraydeque-descendingiterator-method-in-java/) The method returns a reverse order iterator over the deque
10. [element() :](https://www.geeksforgeeks.org/arraydeque-element-method-in-java/) The method returns element at the head of the deque
11. [getFirst():](https://www.geeksforgeeks.org/arraydeque-getfirst-method-in-java/) The method returns first element of the deque
12. [getLast():](https://www.geeksforgeeks.org/arraydeque-getlast-method-in-java/) The method returns last element of the deque
13. [isEmpty():](https://www.geeksforgeeks.org/arraydeque-isempty-method-in-java/) The method checks whether the deque is empty or not.
14. [toArray():](https://www.geeksforgeeks.org/arraydeque-toarray-method-in-java/) The method returns array having the elements of deque.
15. [offer(Element e) :](https://www.geeksforgeeks.org/arraydeque-offer-method-in-java/) The method inserts element at the end of deque.
16. [offerFirst(Element e) :](https://www.geeksforgeeks.org/arraydeque-offerfirst-method-in-java/) The method inserts element at the front of deque.
17. [offerLast(Element e) :](https://www.geeksforgeeks.org/arraydeque-offerlast-method-in-java/) The method inserts element at the end of deque.
18. [peek() :](https://www.geeksforgeeks.org/arraydeque-peek-method-in-java/) The method returns head element without removing it.
19. [peekFirst() :](https://www.geeksforgeeks.org/arraydeque-peekfirst-method-in-java/) The method returns first element without removing it.
20. [peekLast() :](https://www.geeksforgeeks.org/arraydeque-peeklast-method-in-java/) The method returns last element without removing it.
21. [poll() :](https://www.geeksforgeeks.org/arraydeque-poll-method-in-java/) The method returns head element and also removes it
22. [pollFirst() :](https://www.geeksforgeeks.org/arraydeque-pollfirst-method-in-java/) The method returns first element and also removes it
23. [pollLast() :](https://www.geeksforgeeks.org/arraydeque-polllast-method-in-java/) The method returns last element and also removes it
24. [pop() :](https://www.geeksforgeeks.org/arraydeque-pop-method-in-java/) The method pops out an element for stack repesented by deque
25. [push(Element e) :](https://www.geeksforgeeks.org/arraydeque-push-method-in-java/) The method pushes an element onto stack repesented by deque
26. [remove() :](https://www.geeksforgeeks.org/arraydeque-remove-method-in-java/) The method returns head element and also removes it
27. [removeFirst() :](https://www.geeksforgeeks.org/arraydeque-removefirst-method-in-java/) The method returns first element and also removes it
28. [removeLast() :](https://www.geeksforgeeks.org/arraydeque-removelast-method-in-java/) The method returns last element and also removes it
29. [removeFirstOccurrence(Obj) :](https://www.geeksforgeeks.org/arraydeque-removefirstoccurrence-method-in-java/) The method removes the element where it first occur in the deque.
30. [removeLastOccurrence(Obj) :](https://www.geeksforgeeks.org/arraydeque-removelastoccurrence-method-in-java/) The method removes the element where it last occur in the deque.



## Stack

**ArrayDeque<>():**

APIs:

1. add(obj) //cannot add null
2. removeLast()

```java
Deque<TreeNode> stack = new ArrayDeque<>();
stack.add(root);
TreeNode curr = stack.removeLast();
```



**LinkedList<>()**

APIs:

1. add(obj) // can be null
2. pollLast()



```java
LinkedList<TreeNode> stack = new LinkedList<>();
stack.add(root);
TreeNode curr = stack.pollLast();
```



# Algorithms

## DFS

### Inorder

**1. Using a stack**

1. Create a stack using ArrayDeque<>()
2. Recur if stack is not empty or root is not null 
   1. Push root to the stack
   2. Check if root.left exists. If yes, repeat step 1 
   3. // Do something
   4. Check root.right

```java
Public inorder(TreeNode root){
    Deque<TreeNode> stack = new ArrayDeque<>();
    while(!stack.empty() || root!= null){
        //add root.left to stack
        while(root != null){
            stack.add(root);
            root = root.left;
        }
        root = stack.removeLast();
        System.out.println("visiting: "+root.val);
        /** 		
       		Do something here
        **/
        root = root.right;
    }
}
```

