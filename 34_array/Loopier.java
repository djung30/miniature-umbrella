/***
 * Walrus (Humans: Daniel Jung, Joshua Yagupsky, Ethan Lam; Ducks: Ralph, Quacker, Carl)
 * APCS
 * HW34 -- A Pirate's Life for Me
 * 2021-11-14
 * time spent: 1hrs
 * QCC:
 		-
 * Disco:
 		- For arrays, unlike strings, length is a property/attribute, not a method. Thus, you don't need parentheses after it.
    - Arrays.copyOf and copyOfRange can be used to slice arrays, similar to how we sliced strings
 ***/

import java.util.Arrays;
import java.util.Random;

public class Loopier {
  public static Random rando = new Random();
  public static void randGenInt(int[] arr, int max) {
      for (int i = 0; i < arr.length; i++) {
          arr[i] = rando.nextInt(max);
      }
  }

  public static String arrayToString(int[] arr) {
    String out = "{";
    for(int i = 0; i < arr.length; i++) {
      out += arr[i];
      if (i < arr.length-1) {
          out += ", ";
      }
    }
    out += "}";
    return out;
  }

  public static int linSearch(int[] a, int target){
    for(int i = 0; i < a.length; i++){
      if(a[i] == target){
        return i;
      }
    }
    return -1;
  }

  public static int freq(int[] arr, int target) {
    int out = 0;
    for (int num : arr) {
      if (num == target) {
        out++;
      }
    }
    return out;
  }

  public static int linSearchR(int[] a, int target){
    if(a[0] == target){
      return 0;
    }
    else if (a.length == 1){
      return -1;
    }
    else if (linSearchR(Arrays.copyOfRange(a,1,a.length),target) == -1){
      return -1;
    }
    else{
      return linSearchR(Arrays.copyOfRange(a,1,a.length),target) + 1;
    }
  }

  public static int freqRec(int[] a, int target) {
    int out = 0;
    if(a[a.length-1] == target){
      out++;
    }
    if (a.length != 1){
      out += freqRec(Arrays.copyOf(a,a.length-1),target);
    }
    return out;
  }

  public static void main(String[] args) {
    int[] a = {2,3,4,5,6,7,8,9,10,11,23,11,5,3,837483748,12,13,14,15,16};
    randGenInt(a,10);
    System.out.println(arrayToString(a));
    System.out.println("/search");
    System.out.println(linSearch(a, 10));
    System.out.println(linSearch(a, 4));
    System.out.println("/freq");
    System.out.println(freq(a, 10));
    System.out.println(freq(a, 4));
    System.out.println("/searchR");
    System.out.println(linSearchR(a, 10));
    System.out.println(linSearchR(a, 4));
    System.out.println("/freqR");
    System.out.println(freqRec(a, 10));
    System.out.println(freqRec(a, 4));
  }
}
