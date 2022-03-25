
// A Dog's Dream (David Chen + Daniel Jung + Abdullah Faraque)
// APCS pd8
// HW81: Thank You, Next
// 2022-03-24r
// time spent: 0.5 hrs

/***
 * class ItrWork
 *  SKELETON
 * Facilitates familiarization with iterators
 **/

/***
    DISCO
      - Iterator is generically typed
    QCC
      - what is the meaning of life

    SUMMARY THE FIRST:

    Iterator is an Interface that allows us to obtain one element at a time.
    hasNext() returns true if the collection has more elements.
    remove() removes the current element
    next() returns the next element

    SUMMARY THE SECOND:

    ItrWork allows to use methods such as foundA and foundB to indicate whether a key
    is present in a collection. odd() returns a list of all odd numbers and even() returns
    all even numbers. removeEvens() returns the list without all the evens. There are, however,
    different ways of implementing each method, namely using the iterator or doing it wich a FOR-EACH
    loop
**/

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork {

  // using FOREACH loop
  // returns a boolean to indicate whether key is present in L
  public static boolean foundA(Integer key,
      List<Integer> L) {
    for (Integer i : L) {
      if (key.equals(i)) {
        return true;
      }
    }
    return false;
  }

  // explicitly using an iterator
  // returns a boolean to indicate whether key is present in L
  public static boolean foundB(Integer key,
      List<Integer> L) {
    Iterator it = L.iterator();
    while (it.hasNext()) {
      if (it.next().equals(key)) {
        return true;
      }
    }
    return false;
  }

  // using FOREACH loop
  // returns a list containing the odd numbers in L
  public static List<Integer> oddsA(List<Integer> L) {
    List<Integer> result = new ArrayList<Integer>();
    for (Integer i : L) {
      if (i % 2 != 0) {
        result.add(i);
      }
    }
    return result;
  }

  // explicitly using an iterator
  // returns a list containing the odd numbers in L
  public static List<Integer> oddsB(List<Integer> L) {
    List<Integer> result = new ArrayList<Integer>();
    Iterator it = L.iterator();

    while (it.hasNext()) {
      Object num = it.next();
      if ((int) num % 2 != 0) {
        result.add((int) num);
      }
    }
    return result;
  }

  // explicitly using an iterator
  // modifies L s.t. it contains no evens
  public static void removeEvens(List<Integer> L) {
    Iterator it = L.iterator();
    while (it.hasNext()) {
      Object num = it.next();
      if ((int) num % 2 == 0) {
        it.remove();
      }
    }
  }

  public static void main(String[] args) {

    // var type: List obj type: ?
    List<Integer> L = new ArrayList<Integer>();

    for (int i = 0; i < 10; i++)
      L.add(i);

    // TASK: write code to print the contents of L...

    // a) using a FOREACH loop

    // b) explicitly using an iterator

    System.out.println("\nTesting foundA...");
    System.out.println("9 in L? -> " + foundA(9, L));
    System.out.println("13 in L? -> " + foundA(13, L));

    System.out.println("\nTesting foundB...");
    System.out.println("9 in L? -> " + foundB(9, L));
    System.out.println("13 in L? -> " + foundB(13, L));

    System.out.println("\nTesting oddsA...");
    List<Integer> A = oddsA(L);
    for (int n : A)
      System.out.println(n);

    System.out.println("\nTesting oddsB...");
    List<Integer> B = oddsB(L);
    for (int n : B)
      System.out.println(n);

    System.out.println("\nTesting removeEvens...");
    removeEvens(L);
    for (int n : L)
      System.out.println(n);
    /*
     * ~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

  }// end main

}// end class ItrWork