/* The Rainbow Monkeys (Humans: Daniel, Gloria, Jacob; Ducks: Ralph, Flounder, Preguac)
APCS
HW27: FOR the Love of Strings
2021 10 28
QCC: What is the cleanest way that we can write this code? Is a recursive or iterative method more efficient? Are there instances where a while loop is better than using a for loop?
Disco:
	- String.length gives the # of characters in a string
  - The second parameter of String.substring is exclusive
Time Spent: 1hr
*/

public class Rof{

// FOR Loop Fence Method
  public static String fenceF(int posts) {
    String fence = "|";
    for (int i = 1; i < posts; i++) {
      fence += "--|";
		}
    return fence;
  }
  
// FOR Loop Reverse String
  public static String reverseF(String s) {
    String rs = "";
    for (int i = s.length()-1; i >= 0 ; i--) {
				rs += s.substring(i, i+1);
		}
    return rs;
  }
  
// RECURSION Loop Reverse String
  static String rs = "";
  public static String reverseR(String s){
  
    if (s.length() == 0){
      return rs;
    }
    else{
      rs += s.substring(s.length()-1, s.length());
      return reverseR(s.substring(0,s.length()-1));
    }
  }
                      
//main method to test cases
  public static void main(String[] args){
    System.out.println(fenceF(1));
    System.out.println(fenceF(2));
    System.out.println(fenceF(3));
    System.out.println(reverseF("desserts"));
    System.out.println(reverseR("desserts"));
  }

}