/*
Given an array of ints, return true if the array is length 1 or more, and the first element and the last element are equal.
*/
public class SameFirstLast{
	public static boolean sameFirstLast(int[] nums) {
	  	if(nums.length >= 1 && nums[0] == nums[nums.length-1]){
	    		return true;
	  	}
	  	return false;
	}
	public static void main(String[] args){
		int[] a = {1,2,3};
		System.out.println(sameFirstLast(a));
		int[] b ={1,2,3,1};
		System.out.println(sameFirstLast(b));
		int[] c ={1,2,1};
		System.out.println(sameFirstLast(c));
	}
}
