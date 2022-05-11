//A Dog's Dream: Abdullah Faruque, David Chen, Daniel Jung
//APCS pd08
//HW95: Algorithm as Data Structure
//2022-05-09M
//time spent: 0.5 hours

/**
 * class TreeNode
 * SKELETON
 * Implements a node for use in a binary tree.
 * Only holds int cargo.
 */

public class TreeNode
{

  //instance variables / attributes of a TreeNode:
  int _cargo;        //this node's data
  TreeNode _lt, _rt; //pointers to left, right subtrees


  /**
   * default constructor
   * Construct a tree node with specified value,
   * with null left and right subtrees.
   */
  TreeNode( int initValue )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    _cargo = initValue;
  }


  /**
   * overloaded constructor
   * Construct tree node w specified value, left, and right subtrees.
   */
  TreeNode( int initValue, TreeNode initLeft, TreeNode initRight )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    _cargo = initValue;
    _lt = initLeft;
    _rt = initRight;
  }


  /**
   * Returns the left subtree of this node.
   */
  TreeNode getLeft()
  {
    return _lt;
    /*** YOUR IMPLEMENTATION HERE ***/
  }


  /**
   * Returns the right subtree of this node.
   */
  TreeNode getRight()
  {
    return _rt;
    /*** YOUR IMPLEMENTATION HERE ***/
  }


  /**
   * Returns the value stored in this tree node.
   */
  int getValue()
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    return _cargo;
  }


  /**
   * Sets the value of the left subtree of this node.
   */
  void setLeft( TreeNode theNewLeft )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    _lt = theNewLeft;
  }


  /**
   * Sets the value of the right subtree of this node.
   */
  void setRight( TreeNode theNewRight )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    _rt = theNewRight;
  }


  /**
   * Sets the value of this tree node.
   */
  void setValue( int theNewValue ) 
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    _cargo = theNewValue;
  }

}//end class
