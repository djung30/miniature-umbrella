public class Methods {
  public static boolean isDivisible(int m,int n) {
    if (n % m == 0) {
      return true;
    } else {
      return false;
    }
  }
  public static boolean isTriangle(int x, int y, int z) {
    if ((x+y>z) && (y+z>x) && (x+z>y)) {
      return true;
    } else { return false;
    }
  }
  public static int ack(int m,int n){
    if (m==0) {
      return n +1;
    }
    if ((n==0) && (m>0)) {
      return ack(m-1,1);
    } else{
      return ack(m-1,ack(m,n-1));
    }
  }
  public static void main(String[] args){
    System.out.println(ack(2,3));
  }
}
