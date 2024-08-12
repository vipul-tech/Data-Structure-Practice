package stack;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluation {
	
	public int evaluatePostfix(String postfix) {
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<postfix.length();i++) {
			
			char ch = postfix.charAt(i);
			
			if (ch == ' ')
                continue;
			
			else if(Character.isDigit(ch)) {
				stack.push(ch-'0');
//				int n = 0;
//				 
//                // Extract the characters and store it in num
//                while (Character.isDigit(ch)) {
//                    n = n * 10 + (int)(ch - '0');
//                    i++;
//                    if(i<postfix.length())
//                    	ch = postfix.charAt(i);
//                }
//                i--;
// 
//                // Push the number in stack
//                stack.push(n);
			}
			
			else {
				int value1 = stack.pop();
				int value2 = stack.pop();
				switch(ch) {
				case '+':
					stack.push(value2+value1);
					break;
				case '-':
					stack.push(value2-value1);
					break;
				case '*':
					stack.push(value2*value1);
					break;
				case '/':
					stack.push(value2/value1);
					break;
				}
			}
			
		}
		 return stack.pop();
	}
	
	public static void main(String[] args) {
		PostfixEvaluation postfixEvaluation = new PostfixEvaluation();
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter postfix expression to evaluate : ");
			String postfixExpression = sc.next();
			System.out.println("Postfix expression : " + postfixExpression);
			int value = postfixEvaluation.evaluatePostfix(postfixExpression);
			System.out.println("Evaluated postfix expression : " + value);
		}
	}

}
