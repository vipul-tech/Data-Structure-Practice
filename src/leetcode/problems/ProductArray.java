package leetcode.problems;

public class ProductArray {
	//1, 2, 3, 4-->1,1,2,6->24,12,8,6
	public int[] findProduct(int[] nums) {
		int[] result = new int[nums.length];
		int product = 1;
		for(int i=0;i<nums.length;i++) {
			result[i] = product;
			product = product * nums[i];
		}
		product=1;
		for(int i=nums.length-1;i>=0;i--) {
			result[i] = result[i] * product;
			product = product * nums[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		ProductArray productArray = new ProductArray();
		int[] nums = {-1, 1, 0, -3, 3};//{1, 2, 3, 4};
		int[] result = productArray.findProduct(nums);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i] + " ");
		}
	}

}
