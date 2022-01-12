/***
 * Walrus (Humans: Daniel Jung, Joshua Yagupsky, Ethan Lam; Ducks: Ralph, Quacker, Carl)
 * APCS
 * HW55 -- Big O for OrderedArrayList
 * 2022-1-11
 * time spent: 0.35 hours
 ***/

import java.util.ArrayList;

public class OrderedArrayList{
  private ArrayList<Integer> _data;
  //Default constructor
  public OrderedArrayList(){
    _data = new ArrayList<Integer>();
  }

  //toString method
  /*
  There is no best or worst case for this method, since the difficulty of toString depends only on the length of the ArrayList
  This method is always O(n), since we need to traverse through every element of the ArrayList to add to our String
  */
  public String toString(){
    return _data.toString();
  }

  //remove method
  /*
  The best case is when the index is the last index of the ArrayList, since we will not have to move any elements left to fill in the space.
  The worst case is when we try to remove the first index, since every element will have to be moved to the left.
  The method is O(n), since we need to move a number of elements on the order of the size of the collection to the left.
  */
  public Integer remove( int index )
  {
    return _data.remove(index);
  }

  //add method
  /*
  See addLinear and addBinary
  */
  public boolean add(Integer newVal){

    addLinear(newVal);
    return true;
  }

  //addLinear method
  /*
  The best case is when the element to add is at the beginning, since we won't have to compare any more elements.
  The worst case is when the element to add is at the end of the array, as the method will have to compare the maximum # of elements.
  The method is O(n), since we have to traverse through a number of elements on the order of the size of the collection.
  */
  public void addLinear(Integer newVal){
    for(int i = 0; i < size(); i++){
      if(_data.get(i) > element){
        _data.add(i,element);
      }
    }
    _data.add(element);
  }

  //addBinary method
  /*
  The best case is when the element to add is in the middle, since this is the first place a binary search will find.
  The worst case is when element to add is at either extreme, as its the last place binary search will find.
  The method is O(log(n)), since we have to run a number of comparisons on the order of the logarithm of the size of the collection.
  This is because every comparison eliminates half of the remaining possibilities, unlike a linear search where each comparison elliminates one possibility.
  */
  public void addBinary(Integer newVal)
  {
    int lo = 0;
    int med = 0;
    int hi = _data.size()-1;

    while ( lo <= hi ) {
      med = (lo + hi) / 2;
      int x = _data.get(med).compareTo( newVal );

      if ( x == 0 ) {
        _data.add( med, newVal );
        return;
      }
      else if ( x > 0 )
        hi = med - 1;
      else
        lo = med + 1;
    }
    _data.add( lo, newVal );
  }

  //get method
  /*
  There is no best or worst case, we are just getting the value of a variable.
  The method is O(1), since we are just getting the value of a variable.
  */
  public int get(int index){
    return _data.get(index);
  }

  //size method
  /*
  There is no best or worst case scenario as the size is a stored variable.
  The method is O(1)
  */
  public int size(){
    return _data.size();
  }
}
