public class Loopier {
  /*public static int[] randGenInt() {

  }
  */

  public static String arrayToString(int[] arr) {
    String out = "{";
    for(int num : arr) {
      out += num;
      out += ", ";

    }
    out += "}";
    return out;
  }
  public static void main(String[] args) {
    int[] a = {2,3,4,5,6,7,8};
    System.out.println(arrayToString(a));
  }
}
