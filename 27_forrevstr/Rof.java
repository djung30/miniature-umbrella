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

  public static void main(String[] args){
    System.out.println(fenceF(8));
    System.out.println(fenceF(1));
  }

}
