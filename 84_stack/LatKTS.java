// A Dog's Dream (David Chen + Daniel Jung + Abdullah Faraque)
// APCS pd8
// HW84: Stack: What Is It Good For?
// 2022-03-30w
// time spent: 0.6 hrs

/***
 * DISCO
 * isEmpty method for strings??? (stumbled upon by accident)
 * QCC
 * Is there a more efficient way to implement allMatched
 **/

/***
 * class LatKtS
 * SKELETON
 * driver class for Latkes
 * Uses a stack to reverse a text string, check for sets of matching parens.
 **/

public class LatKtS {

  /***
   * precondition: input string has length > 0
   * postcondition: returns reversed string s
   * flip("desserts") -> "stressed"
   **/

  public static String flip(String s) {
    Latkes stack = new Latkes(s.length());
    for (int i = 0; i < s.length(); i++) {
      stack.push(s.substring(i, i + 1));
    }
    String ret = stack.pop();
    while (!stack.isEmpty()) {
      ret += stack.pop();
    }
    return ret;
  }

  /***
   * precondition: s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" ) -> true
   * allMatched( "([)]" ) -> false
   * allMatched( "" ) -> true
   **/
  public static boolean allMatched(String s) {
    if (s.isEmpty())
      return true;
    Latkes stack = new Latkes(s.length());
    for (int i = 0; i < s.length(); i++) {
      String current = s.substring(i, i + 1);

      if (current.equals("(") || current.equals("{") || current.equals("[")) {
        stack.push(current);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        String top = stack.peek();

        if ((current.equals(")") && !top.equals("(")) || (current.equals("}") && !top.equals("{"))
            || (current.equals("]") && !top.equals("["))) {
          return false;
        } else {
          stack.pop();
        }
      }
    }
    return stack.isEmpty();
  }

  // main method to test
  public static void main(String[] args) {
    System.out.println(flip("stressed"));
    System.out.println(allMatched("({}[()])")); // true
    System.out.println(allMatched("([)]")); // false
    System.out.println(allMatched("(){([])}")); // true
    System.out.println(allMatched("](){([])}")); // false
    System.out.println(allMatched("(){([])}(")); // false
    System.out.println(allMatched("()[[]]{{{{((([])))}}}}")); // true
    /*
     * v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
     * ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^
     */
  }

}// end class
