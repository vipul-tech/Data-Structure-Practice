package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatingCharacter {
	
	public int firstNonRepeatingCharacter(String str) {
		String lowerCaseStr = str.toLowerCase();
		char[] chars = lowerCaseStr.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		
		for(char ch : chars) {
			map.put(ch, map.getOrDefault(ch,0)+1);
		}
		
		for(int i=0;i<chars.length;i++) {
			char ch = chars[i];
			if(map.get(ch)==1) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		NonRepeatingCharacter nonRepeatingCharacter = new NonRepeatingCharacter();
		String str = "codeforcode";
		System.out.println("First non-repeating character for " + str + " is at "
				+ "index : " + nonRepeatingCharacter.firstNonRepeatingCharacter(str));
	}

}
