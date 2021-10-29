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
    for (int i = s.length()-1; i >= 0 ; i--) {
				rs += s.substring(i, i+1);
		}
    return rs;
  }
  
  public static String reverseR(String s){
    String rs = "";
    int
    if (rs.length()==s.length()){
      return rs;
    }
    else{
      rs += s.substring(s.length()-1, s.length());
      return reverseR(s.substring(0,s.length()-1));
    }
  }
                      

  public static void main(String[] args){
    System.out.println(fenceF(1));
    System.out.println(fenceF(2));
    System.out.println(fenceF(3));
    System.out.println(reverseF("desserts"));
    System.out.println(reverseR("desserts"));
  }

}