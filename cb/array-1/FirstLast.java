/*
Given an array of ints, return true if 6 appears as either the first or last element in the array. The array will be length 1 or more.
*/
public class FirstLast{
	public static boolean firstLast6(int[] nums){
		if(nums.length < 1){
			return false;
		}
		if(nums[0] == 6 || nums[nums.length-1] == 6){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void main(String[] args){
		int[] a = {1,2,6};
		System.out.println(firstLast6(a));
		int[] b = {6,1,2,3};
		System.out.println(firstLast6(b));
		int[] c = {13,6,1,2,3};
		System.out.println(firstLast6(c));
	}
}
