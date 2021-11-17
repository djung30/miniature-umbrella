/*
Return the number of even ints in the given array. Note: the % "mod" operator computes the remainder, e.g. 5 % 2 is 1.
*/
public class CountEvens {
    public static int countEvens(int[] nums) {
        int count = 0;
        for (int i = 0; i<nums.length; i++) {
          if ((nums[i] % 2) == 0) {
            count++;
          }
        }
        return count;
      }
    public static void main(String[] args) {
        System.out.println(countEvens(new int[] {2,1,2,3,4}));
        System.out.println(countEvens(new int[] {2,2,0}));
        System.out.println(countEvens(new int[] {1,3,5}));
    }
}
