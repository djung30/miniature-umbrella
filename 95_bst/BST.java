//A Dog's Dream: Abdullah Faruque, David Chen, Daniel Jung
//APCS pd08
//HW95: Algorithm as Data Structure
//2022-05-09M
//time spent: 0.5 hours

/**
 * class BST
 * v1:partial
 * SKELETON
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 * and any value in its right subtree must be greater.)
 *
 * This BST implementation only holds ints (its nodes have int cargo)
 */

public class BST {

  // instance variables / attributes of a BST:
  TreeNode _root;

  /**
   * default constructor
   */
  BST() {
    /*** YOUR IMPLEMENTATION HERE ***/
    _root = null; // initialize root to null
  }

  /**
   * void insert( int )
   * Adds a new data element to tree.
   */
  public void insert(int newVal) {
    TreeNode newNode = new TreeNode(newVal);
    /*** YOUR IMPLEMENTATION HERE ***/

    if (_root == null) {
      _root = newNode;
      return;
    }

    insert(_root, newNode);
  }

  // recursive helper for insert(int)
  public void insert(TreeNode stRoot, TreeNode newNode) {
    /*** YOUR IMPLEMENTATION HERE ***/
    if (newNode.getValue() < stRoot.getValue()) {
      if (stRoot.getLeft() == null) {
        stRoot.setLeft(newNode);
      } else {
        insert(stRoot.getLeft(), newNode);
      }
    } else {
      if (stRoot.getRight() == null) {
        stRoot.setRight(newNode);
      } else {
        insert(stRoot.getRight(), newNode);
      }
    }
  }// end insert()

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  // ~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  // process root, recurse left, recurse right
  public void preOrderTrav() {
    preOrderTrav(_root);
  }

  public void preOrderTrav(TreeNode currNode) {
    /*** YOUR IMPLEMENTATION HERE ***/
    if (currNode != null) {
      System.out.println(currNode.getValue());
      preOrderTrav(currNode.getLeft());
      preOrderTrav(currNode.getRight());
    }
  }

  // recurse left, process root, recurse right
  public void inOrderTrav() {
    /*** YOUR IMPLEMENTATION HERE ***/
    inOrderTrav(_root);
  }

  public void inOrderTrav(TreeNode currNode) {
    /*** YOUR IMPLEMENTATION HERE ***/
    if (currNode != null) {
      inOrderTrav(currNode.getLeft());
      System.out.println(currNode.getValue());
      inOrderTrav(currNode.getRight());
    }
  }

  // recurse left, recurse right, process root
  public void postOrderTrav() {
    /*** YOUR IMPLEMENTATION HERE ***/
    postOrderTrav(_root);
  }

  public void postOrderTrav(TreeNode currNode) {
    /*** YOUR IMPLEMENTATION HERE ***/
    if (currNode != null) {
      postOrderTrav(currNode.getLeft());
      postOrderTrav(currNode.getRight());
      System.out.println(currNode.getValue());
    }
  }

  // ~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  // main method for testing
  public static void main(String[] args) {
    BST arbol = new BST();
    // PROTIP: sketch state of tree after each insertion
    // ...BEFORE executing these.
    arbol.insert(4);
    arbol.insert(2);
    arbol.insert(5);
    arbol.insert(6);
    arbol.insert(1);
    arbol.insert(3);
    System.out.println("\n-----------------------------");
    System.out.println("pre-order traversal:");
    arbol.preOrderTrav();
    System.out.println("\n-----------------------------");
    System.out.println("in-order traversal:");
    arbol.inOrderTrav();
    System.out.println("\n-----------------------------");
    System.out.println("post-order traversal:");
    arbol.postOrderTrav();
    System.out.println("\n-----------------------------");
    /*
     * ~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
  }

}// end class
