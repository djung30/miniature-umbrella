/***
 * class Stckr
 * SKELETON
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 **/

public class Stckr<Z> {
  public static void main(String[] args) {

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // USAGE: un-comment exactly 1 assignment below
    // Stack<Object> cakes = new ALStack<Object>();
    Stack<Object> cakes = new LLStack<Object>();
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    cakes.push(9392);
    cakes.push("pog");
    cakes.push(false);
    cakes.push(2.3);
    cakes.push('a');
    cakes.push("sadbgasihdgasiudgasugbdabsakjs");

    for (int i = 0; i < 10; i++) {
      cakes.push(i * 10);
    }

    while (!cakes.isEmpty()) {
      System.out.println(cakes.peekTop());
      cakes.pop();
    }

    // ...

  }// end main

}// end class
