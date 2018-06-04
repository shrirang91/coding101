/**
 * 
 */
package arrays;

import java.util.Arrays;

/**
 * @author shrirang
 *
 */
public class MaxProductOfThreeNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {-4,-3,-2,-1,60};
		System.out.println("Max product of 3 numbers from the array is :" + maxProductOfThreeNlogN(nums));
		System.out.println("Max product of 3 numbers from the array is :" + maxProductOfThree(nums));
	}
	
	
	//naive solution with O(NlogN) run time
	public static int maxProductOfThreeNlogN(int[] nums) {
		if (nums.length < 3) {
			throw new RuntimeException("less than 3 elements.");
		}
		Arrays.sort(nums);
		int length = nums.length;
		int max1 = nums[length - 1] * nums[length -2] * nums[length -3];
		int max2 = nums[0] * nums[1] * nums[nums.length -1];
		return Math.max(max1, max2);
	}
	
	//O(N) run time solution
	public static int maxProductOfThree(int[] nums) {
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		
		for (int curr : nums) {
			if (curr > max1) {
                max3 = max2;
                max2 = max1;
                max1 = curr;
            }
            else if (curr > max2) {
                max3 = max2;
                max2 = curr;
            }
            else if (curr > max3) {
                max3 = curr;
            }
            if (curr < min1) {
                min2 = min1;
                min1 = curr;
            }
            else if (curr < min2) {
                min2 = curr;
            }
		}
		
		return Math.max(max1*max2*max3, min1*min2*max1);
	}
	
}
