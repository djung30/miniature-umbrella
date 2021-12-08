/***
 * Walrus (Humans: Daniel Jung, Joshua Yagupsky, Ethan Lam; Ducks: Ralph, Quacker, Carl)
 * APCS
 * HW44: Array of Grade 316
 * 2021-12-07
 * time spent: 0.5hrs
 * QCC:
 * Disco:
    - It's useful to have an expandToSize method which will expand _data to a given size if that size is bigger than the old size.
 ***/
import java.util.Arrays;

public class SuperArray{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _size = 0;
    _data = new int[10];
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String s = "[";
    for (int i = 0; i < _size; i++){
      s += _data[i];
      if (i != _size - 1) {
        s += ",";
      }
    }
    s += "]";
    return s;
  }

  //double capacity of SuperArray
  private void expand()
  {
    int [] _temp = Arrays.copyOf(_data,_size);
    _data = new int[_temp.length * 2];
    for (int i = 0; i < _temp.length; i++){
      _data[i] = _temp[i];
    }
  }

  //extend SuperArray capacity to arbitrary length:
  private void expandToSize(int n){
    if (n > _size){
      int [] _temp = Arrays.copyOf(_data,_size);
      _data = new int[n];
      for (int i = 0; i < _temp.length; i++){
        _data[i] = _temp[i];
      }
    }
  }

  //Appends an integer at the end.
  public void add(int item){
    expandToSize(_size+1);
    _data[_size] = item;
    _size++;
  }

  //inserts an integer at the specified index
  public void addAtIndex(int index, int newVal){
    expandToSize(_size+1);
    for (int i = _size; i > index; i--){
      _data[i] = _data[i-1];
    }
    _data[index] = newVal;
    _size++;
  }

  //Removes the element at a given index
  public void remove(int index){
    for (int i = index; i < _size-1; i++){
      _data[i] = _data[i+1];
    }
    _data[_size-1] = 0;
    _size--;
  }
  public int size(){
    return _size;
  }
  //accessor -- return value at specified index
  public int get( int index )
  {
    return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
    expandToSize(index);
    int oldVal = _data[index];
    _data[index] = newVal;
    _size = Math.max(index,_size);
    return oldVal;
  }


  //main method for testing
  public static void main( String[] args )
  {
  	SuperArray bob = new SuperArray();
    System.out.println(bob);
    //Regular add method
    bob.add(3);
    bob.add(5);
    System.out.println(bob);
    //Adding at index
    bob.addAtIndex(0,4);
    bob.addAtIndex(2,9);
    System.out.println(bob);
    //Removal method
    bob.remove(2);
    bob.remove(0);
    System.out.println(bob);
  }//end main()
}//end class
