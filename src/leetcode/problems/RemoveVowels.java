package leetcode.problems;

import java.util.Set;

public class RemoveVowels {
	
	public String removeVowelsFromString(String str) {
		String lowerCaseStr = str.toLowerCase();
		StringBuilder sb = new StringBuilder();
		Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
		char[] chars = lowerCaseStr.toCharArray();
		for(char ch : chars) {
			if(!vowels.contains(ch)) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		RemoveVowels removeVowels = new RemoveVowels();
		String str1 = "What is your name?";
		String str2 = "ice cream";
		System.out.println("After removing vowels from " + str1 + " : "
				+ removeVowels.removeVowelsFromString(str1));
		System.out.println("After removing vowels from " + str2 + " : "
				+ removeVowels.removeVowelsFromString(str2));
	}

}
