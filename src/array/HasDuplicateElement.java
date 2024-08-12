package array;

import java.util.HashSet;
import java.util.Set;

public class HasDuplicateElement {
	
	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<nums.length;i++) {
			if(set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = {7, 3, 1, 4, 3};
		System.out.println("Contains duplicate ? " + containsDuplicate(nums));
	}

}
