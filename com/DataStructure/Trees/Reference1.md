Yes, you can assign `null` to the root node without using a constructor in the
`BinaryTree` class. Here's an alternative way to initialize the root node without a constructor:

```java
class BinaryTree {
  Node root = null;
  
  // Rest of the code...
}
```

In this approach, the root node is directly initialized to `null` during the declaration itself. This achieves the same effect as using a constructor to assign `null` to the root node.

A constructor was used to initialize the root node to `null` as a standard practice and to provide flexibility for future modifications. 

Using a constructor allows you to perform additional tasks or initialization steps when creating an instance of the `BinaryTree` class. In this case, the constructor initializes the root node to `null`, but it could also include other logic or assignments if needed in the future.

The constructor provides a convenient and organized way to set up the initial state of an object. It helps ensure that the object is in a valid and consistent state before any operations are performed on it. In the given code, the constructor sets the root node to `null`, indicating an empty tree initially.