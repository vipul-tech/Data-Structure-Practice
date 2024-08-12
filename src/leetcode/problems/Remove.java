package leetcode.problems;

public class Remove {
	
	public int removeElement(int[] nums, int value) {
		int i = 0;
		for(int j=0;j<nums.length;j++) {
			if(nums[j]!=value) {
				nums[j]=nums[i];
				i++;
			}
		}
		return i;
	}

	public static void main(String[] args) {
		Remove remove = new Remove();
		int nums[] = {3,2,2,3};//{0, 1, 2, 2, 3, 0, 4, 2};
		int result = remove.removeElement(nums, 2);
		System.out.println(result);
	}

}
