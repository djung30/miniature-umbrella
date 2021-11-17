/*
Given an array of ints length 3, return an array with the elements "rotated left"
so {1, 2, 3} yields {2, 3, 1}.
*/
import java.util.Arrays;
public class RotateLeft3{
  public static int[] rotateLeft3(int[] nums) {
    int[] out = new int[3];
    out[0] = nums[1];
    out[1] = nums[2];
    out[2] = nums[0];
    return out;
  }
  public static void main(String[] args){
    System.out.println(Arrays.toString(rotateLeft3(new int[] {1,2,3})));
    System.out.println(Arrays.toString(rotateLeft3(new int[] {5,11,9})));
    System.out.println(Arrays.toString(rotateLeft3(new int[] {7,0,0})));
  }
}
