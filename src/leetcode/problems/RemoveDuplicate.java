package leetcode.problems;

public class RemoveDuplicate {
	
	public int removeDuplicates(int[] nums) {
		int i = 1;
		for(int j=1;j<nums.length;j++) {
			if(nums[j]!=nums[j-1]) {
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}

	public static void main(String[] args) {
		RemoveDuplicate removeDuplicate = new RemoveDuplicate();
		int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5};
		int result = removeDuplicate.removeDuplicates(nums);
		System.out.println("Number of unique element in the array is : " + result);
	}

}
