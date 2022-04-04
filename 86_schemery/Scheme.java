// A Dog's Dream (David Chen + Daniel Jung + Abdullah Faruque)
// APCS pd8
// HW86: What a Racket
// 2022-04-1f
// time spent: 0.8 hrs

//DISCO - We should pop number after doing math

//QCC - N/A
/***
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 * 1. split the given expression and generate a list. set op to 0.
 * 2. iterate through the list.
 * 3. If we encounter an open parentheses, we unload(op, stack). Unloading
 * basically does the math and then pops the number.
 * 4. However, if we encounter "+", "-", or "*", we set op equal to 1,2, or 3
 * respectively.
 * respectively. If we don't encounter any of those symbols, we just push the
 * current element.
 * 5. Lastly we pop.
 *
 * STACK OF CHOICE: Stack by AlStack
 * b/c we don't reaaly need the linked functionality of the LLStack.
 **/

public class Scheme {
  /***
   * precond: Assumes expr is a valid Scheme (prefix) expression,
   * with whitespace separating all operators, parens, and
   * integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   * evaluate( "( + 4 3 )" ) -> 7
   * evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   **/
  public static String evaluate(String expr) {
    Stack<String> stack = new ALStack<String>();
    String[] a = expr.split("\\s+");
    int op = 0;

    for (int i = a.length - 1; i >= 0; i--) {
      if (a[i].equals("(")) {
        String numString = unload(op, stack);
        stack.pop();
        stack.push(numString);
      } else if (a[i].equals("+")) {
        op = 1;
      } else if (a[i].equals("-")) {
        op = 2;
      } else if (a[i].equals("*")) {
        op = 3;
      } else {
        stack.push(a[i]);
      }
      // if (a[i].equals("(")) {
      // tempOp = stack.pop();

      // if (tempOp.equals("+")) {
      // stack.push(unload(1, stack));
      // } else if (tempOp.equals("-")) {
      // stack.push(unload(2, stack));
      // } else if (tempOp.equals("*")) {
      // stack.push(unload(3, stack));
      // } else {
      // stack.push(a[i]);
      // }
      // }
    }
    return stack.pop();
  }// end evaluate()

  /***
   * precond: Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   * Returns the result of operating on sequence of operands.
   * Ops: + is 1, - is 2, * is 3
   **/
  public static String unload(int op, Stack<String> numbers) {
    Integer num = Integer.parseInt(numbers.pop());

    while (!numbers.peekTop().equals(")")) {
      if (op == 1) {
        num += Integer.parseInt(numbers.pop());
      } else if (op == 2) {
        num -= Integer.parseInt(numbers.pop());
      } else if (op == 3) {
        num *= Integer.parseInt(numbers.pop());
      }
    }

    return num.toString();
  }// end unload()

  /*
   * //optional check-to-see-if-its-a-number helper fxn:
   * public static boolean isNumber( String s ) {
   * try {
   * Integer.parseInt(s);
   * return true;
   * }
   * catch( NumberFormatException e ) {
   * return false;
   * }
   * }
   */

  // main method for testing
  public static void main(String[] args) {

    String zoo1 = "( + 4 3 )";
    System.out.println(zoo1);
    System.out.println("zoo1 eval'd: " + evaluate(zoo1));
    System.out.println(zoo1);
    // ...7
    String zoo2 = "( + 4 ( * 2 5 ) 3 )";
    System.out.println(zoo2);
    System.out.println("zoo2 eval'd: " + evaluate(zoo2));
    // ...17
    String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
    System.out.println(zoo3);
    System.out.println("zoo3 eval'd: " + evaluate(zoo3));
    // ...29
    String zoo4 = "( - 1 2 3 )";
    System.out.println(zoo4);
    System.out.println("zoo4 eval'd: " + evaluate(zoo4));
    // ...-4
    /*
     * v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
     * ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^
     */

  }// main()

}// end class Scheme
