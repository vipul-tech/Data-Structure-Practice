package stack;

import java.util.Scanner;
import java.util.Stack;  

public class StringReverse {
	public static String reverse(String str) {
		Stack<Character> stack = new Stack<>();
		char[] chars = str.toCharArray();
		
		for(char c : chars)
			stack.push(c);
		
		for(int i=0;i<str.length();i++)
			chars[i] = (char) stack.pop();
		
		return new String(chars);
	}
	
	public static void main(String[] args) {
		System.out.print("Enter string to reverse : ");
		try (Scanner scanner = new Scanner(System.in)) {
			String str = scanner.next();
			System.out.println("Before reverse : " + str);
			System.out.println("After reverse : " + reverse(str));
		}
	}
}
