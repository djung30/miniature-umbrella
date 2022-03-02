public class Recursion2 {

  public static boolean groupSum(int start, int[] nums, int target) {
    System.out.println(target);
    if (target == 0) {
      return true;
    }
    if (start == nums.length) {
      return false;
    }
    if (groupSum(start+1, nums, target)) {
      return true;
    } else if (groupSum(start+1, nums, target-nums[start])) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    int[] a = {4, 3, 2, 1};
    System.out.println(groupSum(0, a, 7));
  }
  
}
