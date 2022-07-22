import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
  int val;
  Node left;
  Node right;

  Node(int val, Node left, Node right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

public class Problem_2 {

  static Node root = null;
  static Node stRoot = null;
  static List<Integer> arr = new ArrayList<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Provide input to create BST
    System.out.println("Enter the size of your tree : ");
    int n = sc.nextInt();

    // Creating BST
    for (int i = 0; i < n; i++) {
      int element = sc.nextInt();
      root = Problem_2.insert(root, element);
    }

    // Getting the nodes in sorted order in a list
    Problem_2.inOrderTraversal(root);

    // Creating a Skewed BST
    for (int element : arr) {
      Node newNode = new Node(element, null, null);
      if (stRoot == null) {
        stRoot = newNode;
        continue;
      }
      Node temp = stRoot;
      while (temp.right != null) {
        temp = temp.right;
      }
      temp.right = newNode;
    }

    // Displaying in Skewed BST
    System.out.println("\nIn Order : ");
    Problem_2.displayInOrder(stRoot);

    System.out.println("\nPre Order : ");
    Problem_2.displayPreOrder(stRoot);

    System.out.println("\nPost Order : ");
    Problem_2.displayPostOrder(stRoot);
  }

  // Inserting element in a BST
  static Node insert(Node root, int element) {
    Node newNode = new Node(element, null, null);
    if (root == null) {
      root = newNode;
      return root;
    }
    Node temp = root;
    Node pTemp = null;
    while (temp != null) {
      pTemp = temp;
      if (temp.val >= element) {
        temp = temp.left;
      } else {
        temp = temp.right;
      }
    }
    if (pTemp.val >= element) pTemp.left = newNode;
    else pTemp.right = newNode;
    return root;
  }

  // Adding the values in list in sorted order
  static void inOrderTraversal(Node root) {
    if (root != null) {
      inOrderTraversal(root.left);
      arr.add(root.val);
      inOrderTraversal(root.right);
    }
  }

  // Displaying BST with respective traversal order
  static void displayInOrder(Node root) {
    if (root != null) {
      displayInOrder(root.left);
      System.out.print(root.val + ", ");
      displayInOrder(root.right);
    }
  }

  static void displayPreOrder(Node root) {
    if (root != null) {
      System.out.print(root.val + ", ");
      displayPreOrder(root.left);
      displayPreOrder(root.right);
    }
  }

  static void displayPostOrder(Node root) {
    if (root != null) {
      displayPostOrder(root.left);
      displayPostOrder(root.right);
      System.out.print(root.val + ", ");
    }
  }
}
