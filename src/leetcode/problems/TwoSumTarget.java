package leetcode.problems;

import java.util.HashMap;

public class TwoSumTarget {
	
	public static int[] twoSumTarget(int[] numbers, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0;i<numbers.length;i++) {
			if(!map.containsKey(target-numbers[i])) {
				map.put(numbers[i], i);
			} else {
				result[1] = i;
				result[0] = map.get(target-numbers[i]);
				return result;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[] numbers = {2, 11, 5, 10, 7, 8};
		int target = 9;
		int[] result = twoSumTarget(numbers, target);
		System.out.println("[" + result[0] + ", " + result[1] + "]");
	}

}
