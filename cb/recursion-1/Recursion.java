/* Dunking Ducks (Humans: Daniel, Julia; Ducks: Ralph, Flopsy)
APCS
HW64: Revisitation
2022 02 14
*/
public class Recursion {


  public static int factorial(int n) {
    if (n == 0) {
      return 1;
    } else {
      return n * factorial(n-1);
    }
  }

  public static int bunnyEars2(int bunnies) {
    if (bunnies == 0) {
      return 0;
    } else if  (bunnies % 2 == 1) {
      return 2 + bunnyEars2(bunnies-1);
    } else {
      return 3 + bunnyEars2(bunnies-1);
    }
  }

  public static int count7(int n) {
    if (n < 10) {
      if (n == 7) {
        return 1;
      } else {
        return 0;
      }
    } else {
      if (n % 10 == 7) {
        return count7(n/10) + 1;
      } else {
        return count7(n/10);
      }
    }
  }

  public static int countX(String str) {
    if (str.length() <= 1) {
      if (str.equals("x")) {
        return 1;
      } else {
        return 0;
      }
    } else {
      if (str.substring(0, 1).equals("x")) {
        return 1 + countX(str.substring(1));
      } else {
        return countX(str.substring(1));
      }
    }
  }

  public static String changePi(String str) {
    if (str.length() <= 1) {
      return str;
    } else {
      if (str.substring(0,2).equals("pi")) {
        return "3.14" + changePi(str.substring(2));
      } else {
        return str.substring(0, 1) + changePi(str.substring(1));
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(factorial(3));
    System.out.println(bunnyEars2(4));
    System.out.println(count7(10));
    System.out.println(countX("xxxa"));
    System.out.println(changePi("sdfpisdfpisdfpi"))
  }

}
