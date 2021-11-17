// Return an int array length 3 containing the first 3 digits of pi, {3, 1, 4}.
public class MakePi {
  public static int[] makePi() {
    int [] out = {3,1,4};
    return out;
  }
  public static void main(String[] args){
    for (int element : makePi()){
      System.out.println(element);
    }
  }
}
