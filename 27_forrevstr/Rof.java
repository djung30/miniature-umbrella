/* The Rainbow Monkeys (Humans: Daniel, Gloria, Jacob; Ducks: Ralph, Flounder, Preguac)
APCS
HW27: FOR the Love of Strings
2021 10 28
QCC:
Disco:
*/

public class Rof{

  public static String fenceF(int posts) {
    String fence = "|";
    for (int i = 1; i < posts; i++) {
      fence += "--|";
		}
    return fence;
  }
  
  public static String reverseF(String s) {
    String rs = "";
    for (int i = s.length(); i >= 0 ; i--) {
				rs += s.substring(i, i);
		}
    return rs;
  }

  public static void main(String[] args){
    System.out.println(fenceF(1));
    System.out.println(fenceF(2));
    System.out.println(fenceF(3));
  }

}
