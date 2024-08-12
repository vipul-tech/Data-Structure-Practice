package string;

import java.util.Scanner;

public class PalindromeString {
	
	public static void main(String[] args) {
		
		System.out.print("Enter string to check if it is palindrome : ");
		
		try (Scanner sc = new Scanner(System.in)) {
			String str = sc.nextLine();
		
			boolean result = isPalindrome(str);
			
			if(result) {
				System.out.println(str + " is palindrome.");
			}else {
				System.out.println(str + " is not palindrome.");
			}
		}

	}

	private static boolean isPalindrome(String str) {
		char[] charArray = str.toCharArray();
		int start = 0;
		int end = str.length()-1;
		while(start<end) {
			if(charArray[start]!=charArray[end])
				return false;
			start++;
			end--;
		}
		return true;
	}

}
