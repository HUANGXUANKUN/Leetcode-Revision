# Abstract





## Inorder

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

