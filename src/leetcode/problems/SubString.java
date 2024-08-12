package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class SubString {
	
	public int lengthOfLongestSubstring(String str) {
		Map<Character, Integer> map = new HashMap<>();
		int start = 0;
		int maxLength = 0;
		for(int end = 0;end<str.length();end++){
			char ch = str.charAt(end);
			if(map.containsKey(ch)) {
				start = Math.max(start, map.get(ch)+1);
			}
			map.put(ch, end);
			maxLength = Math.max(maxLength, end-start+1);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		String str = "pwwkew";
		SubString subString = new SubString();
		int maxLength = subString.lengthOfLongestSubstring(str);
		System.out.println("Length of longest non-repeating Substring of "+ str + " : " + maxLength);
	}

}
