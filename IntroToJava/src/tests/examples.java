package tests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class examples {
	public static void main(String[] args) {
		int[] arr = { 3,2,4 };

		int target = 6;
		
		System.out.println(Arrays.toString(twoSum(arr, target)));
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(target - nums[i])) {
				return new int[] {i , map.get(target - nums[i])};
			} 
			
			map.put(nums[i], i);
		}

		return new int[0];
	}
}
