package stack;

import java.util.Scanner;
import java.util.Stack;

public class ValidParenthesis {
	
	public boolean isValidParenthesis(String str) {
		Stack<Character> stk = new Stack<>();
		char[] chars = str.toCharArray();
		for(int i=0;i<str.length();i++) {
			if(chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
				stk.push(chars[i]);
			}else {
				if(!stk.isEmpty()) {
					char top = stk.peek();
					if((top=='('&&chars[i]==')') || (top=='{'&&chars[i]=='}') || (top=='['&&chars[i]==']')) {
						stk.pop();
					}
					else {
						return false;
					}
				}else {
					return false;
				}
			}
		}
		return stk.isEmpty();
	}
	
	public static void main(String[] args) {
		ValidParenthesis validParenthesis = new ValidParenthesis();
		int choice = 0;
		try (Scanner sc = new Scanner(System.in)) {
			do {
				System.out.println("1. Check valid parenthesis");
				System.out.println("2. Exit");
				
				System.out.print("Enter choice : ");
				choice = sc.nextInt();
				switch(choice) {
				case 1:
					System.out.print("Enter string of parenthesis for validity check : ");
					String str = sc.next();
					boolean result = validParenthesis.isValidParenthesis(str);
					System.out.println("Is valid? " + result);
					break;
				case 2:
					break;
				default:
					System.out.println("Invalid choice!, Please enter valid choice...");
				}
			}while(choice!=2);
		}
	}
	
}
