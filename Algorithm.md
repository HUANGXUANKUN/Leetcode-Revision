# Algorithms

## DFS

### Inorder

**1. Using a stack**

1. Create a stack using `ArrayDeque<>()`
2. Recursively check if stack is not empty or root is not null 
   1. Push root to the stack
   2. Check if `root.left` exists. If yes, repeat step 1 
   3. `root = stack.pop()`
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



## BFS

### Level Order Traversal

Approach 1: Recursion

Recursively call the function `helper(treeNode, level)`, which takes the current node and its level as the arguments.

The helper function does the followings:

1. Since the output is a `List<ArrayList<nodeValue>> levels`, it appends the current node value to the last `level` in levels. 
2. If the `treeNode` is not null, call `helper(treeNode.left, level+1)` and `helper(treeNode.right, level+1)`.
3. If the treeNode is null, just return.

```java
class Solution {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

         // fulfil the current level
         levels.get(level).add(node.val);

         // process child nodes for the next level
         if (node.left != null)
            helper(node.left, level + 1);
         if (node.right != null)
            helper(node.right, level + 1);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }
}
```

**Complexity Analysis**

- Time complexity : **O(*N*)** since each node is processed exactly once.
- Space complexity :**O(*N*)** to keep the output structure which contains `N` node values.





#### Approach 2: Iteration

**Algorithm**

The recursion above could be rewritten in the iteration form.

Let's keep nodes of each tree level in the *queue* structure, which typically orders elements in a **FIFO** (first-in-first-out) manner. In Java one could use [`LinkedList` implementation of the `Queue` interface](https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html). In Python using [`Queue` structure](https://docs.python.org/3/library/queue.html) would be an overkill since it's designed for a safe exchange between multiple threads and hence requires locking which leads to a performance loose. In Python the queue implementation with a fast atomic `append()` and `popleft()` is [`deque`](https://docs.python.org/3/library/collections.html#collections.deque).

The zero level contains only one node `root`. The algorithm is simple :

- Initiate queue with a `root` and start from the level number `0` : `level = 0`.
- While queue is not empty :
  - Start the current level by adding an empty list into output structure `levels`.
  - Compute how many elements should be on the current level : it's a queue length.
  - Pop out all these elements from the queue and add them into the current level.
  - Push their child nodes into the queue for the next level.
  - Go to the next level `level++`.



```java
class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    if (root == null) return levels;

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    int level = 0;
    while ( !queue.isEmpty() ) {
      // start the current level
      levels.add(new ArrayList<Integer>());

      // number of elements in the current level
      int level_length = queue.size();
      for(int i = 0; i < level_length; ++i) {
        TreeNode node = queue.remove();

        // fulfill the current level
        levels.get(level).add(node.val);

        // add child nodes of the current level
        // in the queue for the next level
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }
      // go to next level
      level++;
    }
    return levels;
  }
}
```

**Complexity Analysis**

- Time complexity : **O(*N*)** since each node is processed exactly once.
- Space complexity : **O(*N*)** to keep the output structure which contains `N` node values.