/***
 * Walrus (Humans: Daniel Jung, Joshua Yagupsky, Ethan Lam; Ducks: Ralph, Quacker, Carl)
 * APCS
 * HW43 -- Array of Steel
 * 2021-12-06
 * time spent: 0.4hrs
 * QCC:
 * Disco:
    -
 ***/
import java.util.Arrays;

public class SuperArray{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _size = 10;
    _data = new int[10];
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String s = "[";
    for (int i = 0; i < _size; i++){
      s += _data[i];
      if (i == _size - 1) {
        s += "]";
      }
      else{
        s += ",";
      }
    }
    return s;
  }

  //double capacity of SuperArray
  private void expand()
  {
    _size *= 2;
    int [] _temp = Arrays.copyOf(_data,_size);
    _data = new int[_size];
    for (int i = 0; i < _temp.length; i++){
      _data[i] = _temp[i];
    }
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
    int oldVal = _data[index];
    _data[index] = newVal;
    return oldVal;
  }


  //main method for testing
  public static void main( String[] args )
  {

      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );
      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i * 2 );
      }
      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);
      for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);
      }
  }//end main()
}//end class
