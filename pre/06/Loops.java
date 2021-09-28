public class Loops {
  public static void main(String[] args) {
    System.out.println(power(2,3));
    System.out.println(factorial(6));
  }
  public static int power(int x, int n) {
    int y = x;
    while (n>1) {
      y = y*x;
      n = n-1;
    }
    return y;
  }
  public static int factorial(int x) {
    int y = x;
    while (x>1) {
      y = y*(x-1);
      x = x-1;
    }
    return y;
  }
  public static double myexp(int x, int n) {
    while 
  }
}
