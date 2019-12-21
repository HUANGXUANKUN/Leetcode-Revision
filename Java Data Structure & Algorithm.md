# Abstract



# Data structures

## Digit and Letter

`Character.isDigit(string.charAt(index))` ([JavaDoc](https://docs.oracle.com/javase/10/docs/api/java/lang/Character.html#isDigit(char))) will return true if it's a digit
`Character.isLetter(string.charAt(index))` ([JavaDoc](https://docs.oracle.com/javase/10/docs/api/java/lang/Character.html#isLetter(char))) will return true if it's a letter

### Conversion between char and int

```java
char five = '5; 
int x = five - '0';
// x = 5
```



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

